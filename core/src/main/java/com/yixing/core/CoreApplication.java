package com.yixing.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yixing.core.dao.PermissionMapper;
import com.yixing.core.entity.Permission;
import com.yixing.core.entity.SysUser;
import com.yixing.core.security.SecurityConstants;
import com.yixing.core.security.code.VerifyServlet;
import com.yixing.core.service.IUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"com.yixing.core.dao.*"})
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings(SecurityConstants.VALIDATE_CODE_PIC_URL);
        return registration;
    }
}
