package com.seata.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.demo.entity.TxStorage;
import org.apache.ibatis.annotations.Mapper;


/**
 * @ClassName: TxStorageMapper
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 18:33
 * @Version V1.0
 */
@Mapper
public interface TxStorageMapper extends BaseMapper<TxStorage> {

}
