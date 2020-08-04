package com.seata.demo.feign;

import com.seata.demo.dto.TxOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: RemoteTxOrderService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-31 10:48
 * @Version V1.0
 */
@FeignClient(contextId = "remoteTxOrderService", value = "seata-tx-order")
public interface RemoteTxOrderService {
    /**
     * @Description: 创建订单
     * @Author: zjb
     * @Date: 2020-07-30
     * @param
     * @Return:
     */
    @PostMapping("/tx-order/create-order")
    public Boolean createOrder(@RequestParam(name = "accountId") Long accountId,
                               @RequestParam(name = "goodsCode") String goodsCode,
                               @RequestParam(name = "count") Integer count);
}
