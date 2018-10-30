package com.telecom.appnmt.Config;

import org.springframework.stereotype.Component;

@Component
public class ServerPort {
    // 全局记录
    private static int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        ServerPort.port = port;
    }
}
