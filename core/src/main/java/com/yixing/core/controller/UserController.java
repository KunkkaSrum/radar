package com.yixing.core.controller;


import com.yixing.core.entity.SysUser;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hyh
 * @since 2019-05-08
 */
@RestController
@RequestMapping("/core/user")
public class UserController  {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultData listUser() {
        List<SysUser> users = iUserService.list();
        return new ResultData(users.size(), StatusCode.OK, "查询成功！", users);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultData listUser(@RequestParam("username")String username) {

        return new ResultData(1, StatusCode.OK, "查询成功！", iUserService.getByUserName(username));
    }
}
