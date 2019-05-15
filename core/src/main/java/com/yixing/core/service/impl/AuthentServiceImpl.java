package com.yixing.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yixing.core.dao.*;
import com.yixing.core.entity.Permission;
import com.yixing.core.entity.SysUser;
import com.yixing.core.service.IAuthentService;
import com.yixing.core.vo.AuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthentServiceImpl implements IAuthentService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<AuthVo> listHasPower(Integer id) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        List<Permission> permissions = permissionMapper.selectList(queryWrapper);

        List<Permission> rolePermissions = permissionMapper.listRP(id);
        System.out.println(rolePermissions.size());
        List<AuthVo> voList = new ArrayList<>();
        for (Permission p : permissions) {
            AuthVo authVo = new AuthVo(
                    p.getId(),
                    p.getName(),
                    "0",
                    p.getPid(),
                    p.getPid()==0 ? "dtree-icon-weibiaoti5" : "",
                    p.getHref(),
                    p.getPermissionNo(),
                    p.getIstype(),
                    p.getIcon(),
                    null
            );
            for (Permission permission : rolePermissions) {
                if (p.getId().equals(permission.getId())) {
                    authVo.setCheckArr("1");

                }
            }
            System.out.println(authVo.getCheckArr());
            voList.add(authVo);

        }

        return voList;
    }

    @Override
    public List<AuthVo> listNav() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        SysUser sysUser = userExtMapper.getByUserName(userDetails.getUsername());
        List<Permission> permissions = permissionMapper.listRP(sysUser.getRoleId());
        List<AuthVo> voList = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission.getIstype() == 0 && permission.getPid() == 0) {
                AuthVo authVo = new AuthVo(
                        permission.getId(),
                        permission.getName(),
                        "1",
                        permission.getPid(),
                        "",
                        permission.getHref(),
                        permission.getPermissionNo(),
                        permission.getIstype(),
                        permission.getIcon(),
                        new ArrayList<>()
                );
                voList.add(authVo);
            }
        }
        for (AuthVo authVo : voList) {
            for (Permission permission : permissions) {
                if (authVo.getId() == permission.getPid()) {
                    authVo.getChildren().add(new AuthVo(
                            permission.getId(),
                            permission.getName(),
                            "1",
                            permission.getPid(),
                            "",
                            permission.getHref(),
                            permission.getPermissionNo(),
                            permission.getIstype(),
                            permission.getIcon(),
                            null
                    ));
                }
            }
        }
        return voList;
    }
}
