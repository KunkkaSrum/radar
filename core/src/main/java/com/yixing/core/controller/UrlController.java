package com.yixing.core.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yixing.core.dao.PermissionMapper;
import com.yixing.core.dao.UserMapper;
import com.yixing.core.entity.SysUser;
import com.yixing.core.model.ResultMap;
import com.yixing.core.security.SecurityConstants;
import com.yixing.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {
    @Autowired
    private PermissionMapper permissionDao;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
    @PreAuthorize("hasPermission('/403','r')")
    public String aa() {
        return "403";
    }

    @RequestMapping("/404")
    public String Page404() {
        return "404";
    }

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

    @RequestMapping("/main")
    @PreAuthorize("hasPermission('/main','r')")
    public String main() {
        return "main";
    }

    /**
     * 处理验证码错误
     */
    @RequestMapping(SecurityConstants.VALIDATE_CODE_ERR_URL)
    public ResultMap codeError() {
        return new ResultMap(getClass().getName() + ":codeError()", "验证码输入错误");
    }

    /****************用户管理***************/
    @RequestMapping("/user/list")
    @PreAuthorize("hasPermission('/user/list','r')")
    public String userList() {
        return "user/userList";
    }

    @RequestMapping("/user/add")
    public String userAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/user/info")
    public String userInfo() {
        return "user/userInfo";
    }

    @RequestMapping("/user/grade")
    public String userGrade() {
        return "user/userGrade";
    }
}
