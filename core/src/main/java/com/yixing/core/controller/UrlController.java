package com.yixing.core.controller;

import com.yixing.core.dao.PermissionMapper;
import com.yixing.core.dao.UserMapper;
import com.yixing.core.log.MyLog;
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

    @MyLog(value = "访问首页")
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
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
    @RequestMapping("/account")
    public String account() {
        return "user/account/account";
    }

    @RequestMapping("/account/opt")
    public String accountOpt() {
        return "user/account/accountOpt";
    }

    @RequestMapping("/role")
    public String role() {
        return "user/role/role";
    }

    @RequestMapping("/role/opt")
    public String roleOpt() {
        return "user/role/roleOpt";
    }

    @RequestMapping("/role/power")
    public String rolePower() {
        return "user/role/rolePower";
    }

    @RequestMapping("/permission")
    public String permissionList() {
        return "user/permission/permission";
    }

    @RequestMapping("/permission/opt")
    public String permissionAdd() {
        return "user/permission/permissionOpt";
    }

    @RequestMapping("/log")
    public String logList() {
        return "system/operateLog";
    }
}
