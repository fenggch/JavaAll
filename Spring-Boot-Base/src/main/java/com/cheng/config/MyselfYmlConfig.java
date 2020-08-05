package com.cheng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-20
 */
@Configuration
@ConfigurationProperties(prefix="my.project.yml")
@PropertySource({"classpath:myselfConfig.yml"})
@Component
public class MyselfYmlConfig {
    @Value("${name}")
    private String name;
    @Value("${version}")
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
