package com.yixing.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yixing.core.entity.SysUser;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultData listUser(@RequestBody(required = false)SysUser sysUser,
                               @RequestParam("page") int page,
                               @RequestParam("limit") int size) {
        SysUser sysUser1 = new SysUser();
        IPage<SysUser> userIPage = iUserService.selectPage(sysUser1,page,size);
        return new ResultData(userIPage.getTotal(), 0, "查询成功！", userIPage.getRecords());
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultData listUser(@RequestParam("username")String username) {
        return new ResultData(1, 0, "查询成功！", iUserService.getByUserName(username));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultData addUser(@RequestBody SysUser sysUser) {
        try{
            iUserService.save(sysUser);
            return new ResultData(1, StatusCode.OK, "添加成功！", null);
        } catch(Exception e) {
            logger.error("UserController->addUser"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "添加失败！", null);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultData updateUser(@RequestBody(required = false) SysUser sysUser) {
        try{
            iUserService.saveOrUpdate(sysUser);
            return new ResultData(1, StatusCode.OK, "添加成功！", null);
        } catch(Exception e) {
            logger.error("UserController->addUser"+e.getMessage());
            return new ResultData(1, StatusCode.ERROR, "添加失败！", null);
        }
    }

}
