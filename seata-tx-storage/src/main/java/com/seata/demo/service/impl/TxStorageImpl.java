package com.seata.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.demo.dto.TxStorageDTO;
import com.seata.demo.entity.TxStorage;
import com.seata.demo.mapper.TxStorageMapper;
import com.seata.demo.service.TxStorageService;
import com.seata.demo.vo.TxStorageVO;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;


/**
 * @ClassName: TxStorageImpl
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:34
 * @Version V1.0
 */
@Service
@Slf4j
public class TxStorageImpl extends ServiceImpl<TxStorageMapper, TxStorage> implements TxStorageService {
    @Resource
    private TxStorageMapper txStorageMapper;

    /**
     * @Description: 扣减库存
     * @Author: zjb
     * @Date: 2020-07-30
     * @param txStorageDTO
     * @Return: void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deduct(TxStorageDTO txStorageDTO){
        log.info("seata 全局事务id={}", RootContext.getXID());
        QueryWrapper<TxStorage> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new TxStorage().setGoodsCode(txStorageDTO.getGoodsCode()));
        TxStorage txStorage = txStorageMapper.selectOne(wrapper);
        txStorage.setCount(txStorage.getCount() - txStorageDTO.getCount());
        txStorageMapper.updateById(txStorage);
        try {
            Thread.sleep(21000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Description: 查询库存-商品代码
     * @Author: zjb
     * @Date: 2020-07-31
     * @param goodsCode
     * @Return: com.zhenxin.txstorage.api.vo.TxStorageVO
     */
    @Override
    public TxStorageVO queryTxStorageByGoodsCode(String goodsCode){
        QueryWrapper<TxStorage> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new TxStorage().setGoodsCode(goodsCode));
        TxStorage txStorage = txStorageMapper.selectOne(wrapper);
        TxStorageVO txStorageVO = new TxStorageVO();
        BeanUtil.copyProperties(txStorage, txStorageVO);
        return txStorageVO;
    }
}
