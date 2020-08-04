package com.seata.demo.controller;

import com.seata.demo.dto.TxOrderDTO;
import com.seata.demo.service.TxOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: TxOrderController
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:10
 * @Version V1.0
 */
@RestController
@RequestMapping("/tx-order")
public class TxOrderController {
    @Resource
    private TxOrderService txOrderService;

    /**
     * @Description: 创建订单
     * @Author: zjb
     * @Date: 2020-07-30
     * @param
     * @Return:
     */
    @PostMapping("/create-order")
    public Boolean createOrder(@RequestParam(name = "accountId") Long accountId,
                               @RequestParam(name = "goodsCode") String goodsCode,
                               @RequestParam(name = "count") Integer count){
        TxOrderDTO txOrderDTO = new TxOrderDTO();
        txOrderDTO.setAccountId(accountId);
        txOrderDTO.setGoodsCode(goodsCode);
        txOrderDTO.setCount(count);
        txOrderService.createOrder(txOrderDTO);
        return Boolean.TRUE;
    }
}
