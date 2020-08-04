package com.seata.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.demo.dto.TxStorageDTO;
import com.seata.demo.entity.TxStorage;
import com.seata.demo.vo.TxStorageVO;

/**
 * @ClassName: TxStorageService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:33
 * @Version V1.0
 */
public interface TxStorageService extends IService<TxStorage> {

    /**
     * @Description: 扣减库存
     * @Author: zjb
     * @Date: 2020-07-30
     * @param txStorageDTO
     * @Return: void
     */
    public void deduct(TxStorageDTO txStorageDTO);

    /**
     * @Description: 查询库存-商品代码
     * @Author: zjb
     * @Date: 2020-07-31
     * @param goodsCode
     * @Return:
     */
    public TxStorageVO queryTxStorageByGoodsCode(String goodsCode);
}
