package com.yixing.core.security.authentication;

import com.alibaba.fastjson.JSONObject;
import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import com.yixing.core.security.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认认证成功处理
 * @author hyh
 * @since 2019/5/8 23:30
 */
@Slf4j
@Component
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String username = ((User) authentication.getPrincipal()).getUsername();
        log.info("认证成功，用户名：{}", username);

        try {
            response.setContentType("application/json;charset=UTF-8");
//             response.sendRedirect(SecurityConstants.LOGIN_SUCCESS_URL);
            response.getWriter().write(JSONObject.toJSONString(new ResultData(0, StatusCode.OK,SecurityConstants.LOGIN_SUCCESS_URL,null)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
