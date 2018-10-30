package com.telecom.appnmt.Config;

import com.telecom.appnmt.Utils.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean  implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Autowired
    private ServerPort serverPort;

    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        // 第一个服务器进程先占用8080端口
        if (NetUtil.isLoclePortUsing(8080)) {
            // 第二个服务器进程再占用9090端口
            server.setPort(9090);
            serverPort.setPort(9090);
        }
        else {
            serverPort.setPort(8080);
        }
    }
}
