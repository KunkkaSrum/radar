package com.yixing.core.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yixing.core.entity.SysUser;
import com.yixing.core.log.MyLog;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultData listUser(@RequestBody(required = false) SysUser sysUser,
                               @RequestParam("page") int page,
                               @RequestParam("limit") int size) {
        IPage<SysUser> userIPage = iUserService.selectPage(sysUser, page, size);
        return new ResultData(userIPage.getTotal(), 0, "查询成功！", userIPage.getRecords());
    }


    @MyLog(value = "添加用户")
    @PreAuthorize("hasPermission('/core/user/add','c')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultData addUser(@RequestBody SysUser sysUser) {
        try {
            sysUser.setInsertTime(LocalDateTime.now());
            iUserService.save(sysUser);
            return new ResultData(1, StatusCode.OK, "添加成功！", null);
        } catch (Exception e) {
            logger.error("UserController->addUser" + e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "添加失败！", null);
        }
    }

    @MyLog(value = "编辑用户")
    @PreAuthorize("hasPermission('/core/user/update','u')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultData updateUser(@RequestBody(required = false) SysUser sysUser) {
        try {
            sysUser.setUpdateTime(LocalDateTime.now());
            iUserService.updateById(sysUser);
            return new ResultData(1, StatusCode.OK, "更新成功！", null);
        } catch (Exception e) {
            logger.error("UserController->updateUser" + e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "更新失败！", e.getMessage());
        }
    }

    @MyLog(value = "删除用户")
    @PreAuthorize("hasPermission('/core/user/delete','d')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultData deleteUser(@RequestParam("userNo") Long userNo) {
        return new ResultData(1, StatusCode.OK, "删除成功！", iUserService.removeById(userNo));
    }

    @RequestMapping(value = "/get/login", method = RequestMethod.GET)
    public ResultData getLogin() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new ResultData(1, StatusCode.OK, "查询成功!",iUserService.getByUserName(userDetails.getUsername()));
    }
}