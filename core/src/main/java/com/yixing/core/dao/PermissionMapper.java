package com.yixing.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yixing.core.entity.Permission;
import com.yixing.core.entity.RolePermission;
import com.yixing.core.entity.SysUser;
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
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT p.* from permission p,role_permission rp WHERE p.id = rp.permit_id and rp.role_id = #{roleId}")
    List<Permission> listRP(Integer roleId);
}
