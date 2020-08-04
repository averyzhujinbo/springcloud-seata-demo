package com.seata.demo.controller;

import com.seata.demo.dto.TxStorageDTO;
import com.seata.demo.service.TxStorageService;
import com.seata.demo.vo.TxStorageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TxStorageController
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:33
 * @Version V1.0
 */
@RestController
@RequestMapping("/tx-storage")
public class TxStorageController {

    @Autowired
    private TxStorageService txStorageService;

    /**
     * @Description: 扣减库存
     * @Author: zjb
     * @Date: 2020-07-31
     * @param txStorageDTO
     * @Return: java.lang.Boolean
     */
    @PostMapping("/deduct")
    public Boolean deduct(@RequestBody TxStorageDTO txStorageDTO){
        txStorageService.deduct(txStorageDTO);
        return Boolean.TRUE;
    }

    /**
     * @Description: 根据商品代码查询库存信息
     * @Author: zjb
     * @Date: 2020-07-31
     * @param goodsCode
     * @Return: TxStorageVO
     */
    @GetMapping("/info/{goodsCode}")
    public TxStorageVO queryTxStorageByGoodsCode(@PathVariable("goodsCode") String goodsCode){
        return txStorageService.queryTxStorageByGoodsCode(goodsCode);
    }
}
