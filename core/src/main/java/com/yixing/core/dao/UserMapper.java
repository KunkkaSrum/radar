package com.yixing.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yixing.core.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    SysUser getByUserName(String username);
}
