package com.seata.demo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName: TxStorageDTO
 * @Description: 库存DTO
 * @Author zjb
 * @Date: 2020-07-30 18:29
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TxStorageDTO {
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
