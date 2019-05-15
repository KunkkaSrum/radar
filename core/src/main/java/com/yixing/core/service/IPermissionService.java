package com.yixing.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yixing.core.entity.Permission;
import com.yixing.core.entity.RolePermission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
public interface IPermissionService extends IService<Permission> {
    List<Permission> listRP(Integer roleId);
}
