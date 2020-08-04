package com.seata.demo.feign;

import com.seata.demo.dto.AccountPayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: RemoteTxAccountService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-31 10:45
 * @Version V1.0
 */
@FeignClient(contextId = "remoteTxAccountService", value = "seata-tx-account")
public interface RemoteTxAccountService {

    /**
     * @Description: 支付金额
     * @Author: zjb
     * @Date: 2020-08-04
     * @param accountPayDTO
     * @Return: java.lang.Boolean
     */
    @PostMapping("seata-account/pay")
    public Boolean payMonery(@RequestBody AccountPayDTO accountPayDTO);
}
