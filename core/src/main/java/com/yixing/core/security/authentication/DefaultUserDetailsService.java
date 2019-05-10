package com.yixing.core.security.authentication;

import com.yixing.core.entity.SysUser;
import com.yixing.core.service.IRolePermissionService;
import com.yixing.core.service.IRoleService;
import com.yixing.core.service.IUserRoleService;
import com.yixing.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 默认 UserDetailService，通过用户名读取信息
 * @author hyh
 * @since 2019/5/8 23:34
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IRolePermissionService iRolePermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = iUserService.getByUserName(username);

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("role_id", user.getRoleId());
        // 添加权限
//        List<RolePermission> rolePermission = iRolePermissionService.listRP(user.getRoleId());
//        System.out.println(rolePermission.size());
//        for (SysUserRole userRole : userRoles) {
//            SysRole role = roleService.getById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(user.getRoleId().toString()));
//        }

        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}