package com.seata.demo.service;

import com.seata.demo.dto.TxOrderDTO;
import com.seata.demo.feign.RemoteTxOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @ClassName: BusinessService
 * @Description:
 * @Author zjb
 * @Date: 2020-08-04 13:46
 * @Version V1.0
 */
@Slf4j
@Service
public class SalesService {
    @Resource
    private RemoteTxOrderService remoteTxOrderService;

    /**
     * @Description: seata 全局事务TM 
     * @Author: zjb
     * @Date: 2020-08-04
     * @param accountId
     * @param goodsCode
     * @param count
     * @Return: java.lang.String
     */
    @GlobalTransactional(timeoutMills=20000,rollbackFor=Exception.class)
    public String sales(Long accountId, String goodsCode, Integer count){
        log.info("seata 全局事务id={}", RootContext.getXID());
        Boolean status = remoteTxOrderService.createOrder(accountId,goodsCode,count);
        log.info("订单创建成功");
        if(status){
            return "商品销售成功!";
        }else {
            return "系统异常，请稍后重试！";
        }
    }
}
