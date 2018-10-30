package com.telecom.appnmt.Controller;

import com.telecom.appnmt.Config.ServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用于测试nginx负载均衡是否正常启动
 */
@RestController
@RequestMapping("/ngx")
public class NginxController {
    @Autowired
    private ServerPort serverPort;

    @RequestMapping(value = "/demo")
    public String a(HttpServletRequest req, HttpServletResponse res) {
        return "当前服务器端口:"+serverPort.getPort();
    }

}
