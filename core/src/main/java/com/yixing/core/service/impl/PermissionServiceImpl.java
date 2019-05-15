package com.yixing.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yixing.core.dao.PermissionMapper;
import com.yixing.core.dao.RolePermissionMapper;
import com.yixing.core.entity.Permission;
import com.yixing.core.entity.RolePermission;
import com.yixing.core.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> listRP(Integer roleId) {
        return permissionMapper.listRP(roleId);
    }
}
