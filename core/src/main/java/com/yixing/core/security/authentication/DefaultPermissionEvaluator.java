package com.yixing.core.security.authentication;

import com.yixing.core.entity.Permission;
import com.yixing.core.entity.RolePermission;
import com.yixing.core.service.IPermissionService;
import com.yixing.core.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 默认权限处理
 * @author hyh
 * @since 2019/1/9 11:13
 */
@Component
public class DefaultPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private IPermissionService iPermissionService;
    @Autowired
    private IRolePermissionService iRolePermissionService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()方法的结果
        User user = (User)authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        // 遍历用户所有角色
        for(GrantedAuthority authority : authorities) {
            String roleId = authority.getAuthority();
//            Integer roleId = roleService.getByName(roleName).getId();
            // 得到角色所有的权限
            List<Permission> rolePermissions = iPermissionService.listRP(Integer.valueOf(roleId));
            System.out.println(rolePermissions.size());
            // 遍历permissionList
            for(Permission permission : rolePermissions) {
                // 获取权限集
//                List permissions = rolePermission.getPermissions();
                // 如果访问的Url和权限用户符合的话，返回true
                if(targetUrl.equals(permission.getHref())) {
                    System.out.println(targetUrl);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}