package com.seata.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.demo.dto.TxOrderDTO;
import com.seata.demo.entity.TxOrder;

/**
 * @ClassName: TxOrderService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:11
 * @Version V1.0
 */
public interface TxOrderService extends IService<TxOrder> {

    /**
     * @Description: 创建订单
     * @Author: zjb
     * @Date: 2020-07-30
     * @param txOrderDTO
     * @Return: void
     */
    public void createOrder(TxOrderDTO txOrderDTO);
}
