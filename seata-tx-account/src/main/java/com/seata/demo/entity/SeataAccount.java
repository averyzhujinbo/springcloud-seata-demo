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
 * @ClassName: SeataAccount
 * @Description: 会员账户实体
 * @Author zjb
 * @Date: 2020-07-30 15:31
 * @Version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_seata_account")
public class SeataAccount implements Serializable {
    private static final long serialVersionUID=1L;

    //主键
    @TableId(value = "account_id", type = IdType.AUTO)
    private Long accountId;

    //账户余额
    @TableField(value = "balance",jdbcType= JdbcType.INTEGER)
    private Integer balance;
}
