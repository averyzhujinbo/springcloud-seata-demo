package com.seata.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.demo.dto.AccountPayDTO;
import com.seata.demo.entity.SeataAccount;


/**
 * @ClassName: TxAccountService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 16:34
 * @Version V1.0
 */
public interface TxAccountService extends IService<SeataAccount> {

    /**
     * @Description: 支付金额
     * @Author: zjb
     * @Date: 2020-07-30
     * @param accountPayDTO
     * @Return: void
     */
    public void payMonery(AccountPayDTO accountPayDTO);
}
