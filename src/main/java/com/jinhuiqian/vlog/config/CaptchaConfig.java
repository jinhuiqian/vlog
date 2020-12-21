package com.jinhuiqian.vlog.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author 231
 * @date 2020-12-11 0:07
 * 验证码配置
 */
@Configuration
public class CaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //验证码长度
        properties.setProperty("Kaptcha.textproducer.char.length", "4");
        //有边框
        properties.setProperty("Kaptcha.border", "yes");
        //边框色
        properties.setProperty("Kaptcha.border.color", "168,184,204");
        //字体颜色
        properties.setProperty("Kaptcha.textproducer.font.color","88,82,135");
        //渐变色
        properties.setProperty("Kaptcha.background.clear.from","197,150,212");
        properties.setProperty("Kaptcha.background.clear.to","76,124,94");
        //字体大小
        properties.setProperty("Kaptcha.textproducer.font.size","30");
        //字体
        properties.setProperty("Kaptcha.textproducer.font.names","微软雅黑");
        //验证码图片大小
        properties.setProperty("kaptcha.image.width", "120");
        properties.setProperty("kaptcha.image.height", "45");
        //验证码保存的key
        properties.setProperty("kaptcha.session.key", "code");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
