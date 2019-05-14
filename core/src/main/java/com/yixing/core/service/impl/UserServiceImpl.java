package com.yixing.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yixing.core.dao.RolePermissionMapper;
import com.yixing.core.dao.UserExtMapper;
import com.yixing.core.dao.UserMapper;
import com.yixing.core.entity.RolePermission;
import com.yixing.core.entity.SysUser;
import com.yixing.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtMapper userExtMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public SysUser getByUserName(String username) {
        return userExtMapper.getByUserName(username);
    }

    @Override
    public IPage<SysUser> selectPage(SysUser sysUser, int page, int size) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>(sysUser);
        Page<SysUser> page1 = new Page<>();
        page1.setCurrent(page);
        page1.setSize(size);
        return userMapper.selectPage(page1,queryWrapper);
    }

    @Override
    public List<RolePermission> listNav() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        SysUser sysUser = userExtMapper.getByUserName(userDetails.getUsername());
        return rolePermissionMapper.listRP(sysUser.getRoleId());
    }
}
