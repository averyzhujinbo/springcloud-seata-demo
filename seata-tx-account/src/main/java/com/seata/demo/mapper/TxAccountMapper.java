package com.seata.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.demo.entity.SeataAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: TxAccountMapper
 * @Description:
 * @Author zjb
 * @Date: 2020-07-30 16:34
 * @Version V1.0
 */
@Mapper
public interface TxAccountMapper extends BaseMapper<SeataAccount> {

}
