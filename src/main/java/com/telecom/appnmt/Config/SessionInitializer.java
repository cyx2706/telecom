package com.telecom.appnmt.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

//初始化Session配置
//@Configuration
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(SessionConfig.class);
    }
}