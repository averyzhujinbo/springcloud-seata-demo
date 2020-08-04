package com.seata.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.demo.entity.TxOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: TxOrderMapper
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:11
 * @Version V1.0
 */
@Mapper
public interface TxOrderMapper extends BaseMapper<TxOrder> {

}
