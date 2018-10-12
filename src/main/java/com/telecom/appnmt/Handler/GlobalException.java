package com.telecom.appnmt.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class GlobalException {
    @ResponseBody
    @ExceptionHandler
    public String processException(Exception e){
        //错误信息
        String info = null;
        // 若该异常类型是系统自定义的异常，直接取出异常信息在错误页面展示即可。
        if(e instanceof RuntimeException){
            info = e.getMessage();
        }else{
            e.printStackTrace();
            // 如果不是RuntimeException，就是其他出现问题
            info = "系统出现未知错误";
        }
        return "{\"status\":false,\"info\":\"" + info + "\"}";
    }
}
