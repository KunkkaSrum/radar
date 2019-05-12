package com.yixing.core.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yixing.core.model.ResultMap;
import com.yixing.core.security.SecurityConstants;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 默认 Session 过期处理
 * @author hyh
 * @since 2019/5/8 23:40
 */
public class DefaultExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
//        ResultMap resultMap = new ResultMap(getClass().getName() + ":onExpiredSessionDetected()",
//                "您的登录已过期，请重新登录。");
//        String json = objectMapper.writeValueAsString(resultMap);
//
//        event.getResponse().setContentType("application/json;charset=UTF-8");
        event.getResponse().sendRedirect(SecurityConstants.PAGE_404);
    }
}
