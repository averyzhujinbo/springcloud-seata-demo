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
 * @ClassName: TxStorage
 * @Description:库存实体
 * @Author zjb
 * @Date: 2020-07-30 15:41
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_seata_storage")
public class TxStorage implements Serializable {
    private static final long serialVersionUID=1L;

    //主键
    @TableId(value = "storage_id", type = IdType.AUTO)
    private Long storageId;

    //商品编码
    @TableField(value = "goods_code")
    private String goodsCode;

    //商品名称
    @TableField(value = "goods_name")
    private String goodsName;

    //商品单价
    @TableField(value = "price")
    private Integer price;

    //库存数量
    @TableField(value = "count")
    private Integer count;
}
