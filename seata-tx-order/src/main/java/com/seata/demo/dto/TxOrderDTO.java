package com.seata.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName: TxOrderDTO
 * @Description: 系统订单DTO
 * @Author zjb
 * @Date: 2020-07-30 17:54
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TxOrderDTO {
    private static final long serialVersionUID=1L;

    //主键
    private Long orderId;

    //账户id
    private Long accountId;

    //商品编码
    private String goodsCode;

    //商品数量
    private Integer count;

    //订单金额
    private Integer money;
}
