package com.seata.demo.controller;

import com.seata.demo.dto.AccountPayDTO;
import com.seata.demo.service.TxAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TxMemberAccountController
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 16:33
 * @Version V1.0
 */
@RestController
@RequestMapping("/seata-account")
public class TxAccountController {
    @Autowired
    private TxAccountService txAccountService;

    /**
     * @Description: 支付金额
     * @Author: zjb
     * @Date: 2020-08-04
     * @param accountPayDTO
     * @Return: Boolean
     */
    @PostMapping("/pay")
    public Boolean payMonery(@RequestBody AccountPayDTO accountPayDTO) {
       txAccountService.payMonery(accountPayDTO);
       return Boolean.TRUE;
    }

}
