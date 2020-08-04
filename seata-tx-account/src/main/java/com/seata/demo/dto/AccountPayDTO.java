package com.seata.demo.dto;


import lombok.Data;

/**
 * @ClassName: AccountPayDTO
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 17:29
 * @Version V1.0
 */
@Data
public class AccountPayDTO {

    //账户ID
    private Long accountId;

    //支付金额
    private Integer money;
}
