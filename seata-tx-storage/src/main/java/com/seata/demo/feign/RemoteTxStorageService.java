package com.seata.demo.feign;

import com.seata.demo.dto.TxStorageDTO;
import com.seata.demo.vo.TxStorageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName: RemoteTxStorageService
 * @Description:
 * @Author zjb
 * @Date: 2020-07-31 10:49
 * @Version V1.0
 */
@FeignClient(contextId = "remoteTxStorageService", value = "seata-tx-storage")
public interface RemoteTxStorageService {
    /**
     * @Description: 扣减库存
     * @Author: zjb
     * @Date: 2020-07-31
     * @param txStorageDTO
     * @Return:
     */
    @PostMapping("tx-storage/deduct")
    public Boolean deduct(@RequestBody TxStorageDTO txStorageDTO);

    /**
     * @Description: 根据商品代码查询库存信息
     * @Author: zjb
     * @Date: 2020-07-31
     * @param goodsCode
     * @Return:
     */
    @GetMapping("tx-storage/info/{goodsCode}")
    public TxStorageVO queryTxStorageByGoodsCode(@PathVariable("goodsCode") String goodsCode);
}
