package com.yixing.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yixing.core.entity.RolePermission;
import com.yixing.core.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
public interface IUserService extends IService<SysUser> {
    SysUser getByUserName(String username);

    IPage<SysUser> selectPage(SysUser sysUser, int page, int size);

    List<RolePermission> listNav();
}
