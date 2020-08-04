package com.seata.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.demo.dto.AccountPayDTO;
import com.seata.demo.dto.TxOrderDTO;
import com.seata.demo.dto.TxStorageDTO;
import com.seata.demo.entity.TxOrder;
import com.seata.demo.feign.RemoteTxAccountService;
import com.seata.demo.feign.RemoteTxStorageService;
import com.seata.demo.mapper.TxOrderMapper;
import com.seata.demo.service.TxOrderService;
import com.seata.demo.vo.TxStorageVO;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: TxOrderImpl
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:11
 * @Version V1.0
 */
@Slf4j
@Service
public class TxOrderImpl extends ServiceImpl<TxOrderMapper, TxOrder> implements TxOrderService {
    @Resource
    private TxOrderMapper txOrderMapper;
    @Resource
    private RemoteTxStorageService remoteTxStorageService;
    @Resource
    private RemoteTxAccountService remoteTxAccountService;

    /**
     * @Description: 创建订单
     * @Author: zjb
     * @Date: 2020-07-30
     * @param txOrderDTO
     * @Return: void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(TxOrderDTO txOrderDTO){
        log.info("seata 全局事务id={}", RootContext.getXID());

        //查询商品单价
        TxStorageVO txStorageVO = remoteTxStorageService.queryTxStorageByGoodsCode(txOrderDTO.getGoodsCode());

        //生成订单
        TxOrder txOrder =  new TxOrder()
                .setAccountId(txOrderDTO.getAccountId())
                .setGoodsCode(txOrderDTO.getGoodsCode())
                .setCount(txOrderDTO.getCount())
                .setMoney(txOrderDTO.getCount() * txStorageVO.getPrice());
        txOrderMapper.insert(txOrder);

        //扣减库存
        TxStorageDTO txStorageDTO = new TxStorageDTO();
        txStorageDTO.setGoodsCode(txOrderDTO.getGoodsCode());
        txStorageDTO.setCount(txOrderDTO.getCount());
        remoteTxStorageService.deduct(txStorageDTO);

        //账户支付订单金额
        AccountPayDTO accountPayDTO = new AccountPayDTO();
        accountPayDTO.setAccountId(txOrderDTO.getAccountId());
        accountPayDTO.setMoney(txOrderDTO.getCount() * txStorageVO.getPrice());
        remoteTxAccountService.payMonery(accountPayDTO);


        if(txOrderDTO.getCount()>txStorageVO.getCount()){
            throw new RuntimeException("商品订单数量大于库存数量");
        }
    }
}
