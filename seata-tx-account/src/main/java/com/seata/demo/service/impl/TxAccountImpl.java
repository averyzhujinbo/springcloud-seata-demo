package com.seata.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.demo.dto.AccountPayDTO;
import com.seata.demo.entity.SeataAccount;
import com.seata.demo.mapper.TxAccountMapper;
import com.seata.demo.service.TxAccountService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName: TxAccountImpl
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 16:35
 * @Version V1.0
 */
@Slf4j
@Service
public class TxAccountImpl extends ServiceImpl<TxAccountMapper, SeataAccount> implements TxAccountService {
    @Resource
    private TxAccountMapper txAccountMapper;
    /**
     * @Description: 支付金额
     * @Author: zjb
     * @Date: 2020-07-30
     * @param accountPayDTO
     * @Return: void
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payMonery(AccountPayDTO accountPayDTO){
        log.info("seata 全局事务id={}", RootContext.getXID());
        QueryWrapper<SeataAccount> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new SeataAccount().setAccountId(accountPayDTO.getAccountId()));
        SeataAccount seataAccount = txAccountMapper.selectOne(wrapper);
        if(accountPayDTO.getMoney() > seataAccount.getBalance()){
            throw new RuntimeException("支付金额大于账户余额！");
        }
        seataAccount.setBalance(seataAccount.getBalance() - accountPayDTO.getMoney());
        txAccountMapper.updateById(seataAccount);
    }
}
