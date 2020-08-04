package com.seata.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * @ClassName: TxOrder
 * @Description: 系统订单实体
 * @Author zjb
 * @Date: 2020-07-30 15:37
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_seata_order")
public class TxOrder implements Serializable {
    private static final long serialVersionUID=1L;

    //主键
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    //账户id
    @TableField(value = "account_id")
    private Long accountId;

    //商品编码
    @TableField(value = "goods_code")
    private String goodsCode;

    //商品数量
    @TableField(value = "count")
    private Integer count;

    //订单金额
    @TableField(value = "money")
    private Integer money;
}
