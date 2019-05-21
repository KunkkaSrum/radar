package com.yixing.core.log;

import com.yixing.core.entity.OperateLog;
import com.yixing.core.service.IOperateLogService;
import com.yixing.core.util.HttpUtil;
import com.yixing.core.util.IdWorker;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private IOperateLogService iOperateLogService;

    @Autowired
    private IdWorker idWorker;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.yixing.core.log.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        OperateLog sysLog = new OperateLog();
        sysLog.setLogNo(idWorker.nextId());
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
//        sysLog.setMethod(className + "." + methodName);
        System.out.println(methodName);

//        //请求的参数
//        Object[] args = joinPoint.getArgs();
//        //将参数所在的数组转换成json
//        String params = JSON.toJSONString(args);
//        sysLog.setParams(params);
        UserDetails userDetails = null;
        sysLog.setCreateTime(new Date());
        if (SecurityContextHolder.getContext()
                .getAuthentication() != null) {
            userDetails = (UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
        }
        //获取用户名
        if (userDetails != null) {
            sysLog.setUsername(userDetails.getUsername());
        } else {
            sysLog.setUsername("游客");
        }


//        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes()))
                .getRequest();
        sysLog.setIp(HttpUtil.getIpAddress(request));

        //调用service保存SysLog实体类到数据库
        iOperateLogService.save(sysLog);
    }

}