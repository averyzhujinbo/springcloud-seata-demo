package com.seata.demo.controller;

import com.seata.demo.dto.TxOrderDTO;
import com.seata.demo.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: BusinessController
 * @Description: 业务销售模块
 * @Author zjb
 * @Date: 2020-08-04 13:46
 * @Version V1.0
 */
@RestController
@RequestMapping("/tx-sales")
public class SalesController {
    @Autowired
    private SalesService salesService;
    /**
     * @Description: 创建订单
     * @Author: zjb
     * @Date: 2020-07-30
     * @param
     * @Return:
     */
    @PostMapping("/order")
    public String sales(@RequestParam(name = "accountId") Long accountId,
                        @RequestParam(name = "goodsCode") String goodsCode,
                        @RequestParam(name = "count") Integer count){
        return salesService.sales(accountId,goodsCode,count);
    }
}
