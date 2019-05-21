package com.yixing.core.controller;

import com.yixing.core.model.ResultData;
import com.yixing.core.model.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
@ResponseBody
public class BaseExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);
    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultData handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return new ResultData(400,"参数解析失败,"+e);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultData handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return new ResultData(405,"不支持当前请求方法,"+e);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultData handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return new ResultData(415,"不支持当前请求方法,"+e);
    }

    /**
     * 500 - Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e) {
        if("不允许访问".equals(e.getMessage())) {
            return new ResultData(StatusCode.ACCESSERROR,"没有权限");
        }
        logger.error("服务运行异常", e);
        return new ResultData(500,"服务器出错,"+e);
    }

}
