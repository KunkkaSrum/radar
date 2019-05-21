package com.yixing.core.security;


/**
 * Security 相关常量
 * @author hyh
 * @since 2019/5/8 23:50
 */
public class SecurityConstants {
    /**
     * 当没有权限时，被引导跳转的 Url
     */
    public static final String UN_AUTHENTICATION_URL = "/login";
    /**
     * 退出登录的 Url
     */

    public static final String LOGOUT_URL = "/logout";
    /**
     * 登陆成功后，被引导跳转的 Url
     */
    public static final String LOGIN_SUCCESS_URL = "/index";
    /**
     * Session 过期被引导跳转的 Url
     */
    public static final String INVALID_SESSION_URL = "/login";

    public static final String PAGE_404 = "/404";

    /**
     * 用户名密码登录请求处理url
     */
    public static final String LOGIN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 验证码登陆表单字段名
     */
    public static final String VALIDATE_CODE_PARAMETER = "verifyCode";

    /**
     * 验证码相关 Url 前缀
     */
    public static final String VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * 图形验证码 Url
     */
    public static final String VALIDATE_CODE_PIC_URL = VALIDATE_CODE_URL_PREFIX + "/getVerifyCode";
    /**
     * 验证码错误 Url
     */
    public static final String VALIDATE_CODE_ERR_URL = VALIDATE_CODE_URL_PREFIX + "/error";
}