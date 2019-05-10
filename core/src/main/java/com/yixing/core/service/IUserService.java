package com.yixing.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yixing.core.entity.SysUser;

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
}
