package com.rrw.donate.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.code.kaptcha.util.Config;
import java.util.Properties;


/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2021-08-04 21:02
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer(){
        Properties properties = new Properties();
        properties.put("kaptcha.border","no");
        properties.put("kaptcha.textproducer.font.color","black");
        properties.put("kaptcha.textpriducer.char.space",5);
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
