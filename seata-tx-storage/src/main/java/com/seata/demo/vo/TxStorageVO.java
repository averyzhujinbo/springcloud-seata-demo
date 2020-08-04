package com.seata.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName: TxStorageVO
 * @Description:库存VO
 * @Author zjb
 * @Date: 2020-07-31 13:46
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TxStorageVO {
    private static final long serialVersionUID=1L;

    //主键
    private Long storageId;

    //商品编码
    private String goodsCode;

    //商品名称
    private String goodsName;

    //商品单价
    private Integer price;

    //库存数量
    private Integer count;
}
