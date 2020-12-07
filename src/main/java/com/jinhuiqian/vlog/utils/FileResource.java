package com.jinhuiqian.vlog.utils;

import lombok.Data;
import org.apache.ibatis.javassist.ClassPath;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 231
 * @date 2020-12-07 16:08
 */
@Data
@Component
@PropertySource("classpath:file.properties")
@ConfigurationProperties(prefix = "file")
public class FileResource {
    private String host;
    private String endpoint;
    private String bucketName;
    private String objectName;
    private String ossHost;
}
