package com.yixing.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yixing.core.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}
