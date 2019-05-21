package com.yixing.core;

import com.yixing.core.security.SecurityConstants;
import com.yixing.core.security.authentication.MyAccessDeniedHandler;
import com.yixing.core.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.AccessDeniedException;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.yixing.core.dao.*"})
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
//    @Bean
//    public ServletRegistrationBean indexServletRegistration() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
//        registration.addUrlMappings(SecurityConstants.VALIDATE_CODE_PIC_URL);
//        return registration;
//    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }


}
