package com.cheng.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-19
 */
@ConfigurationProperties(prefix="project.info")
public class ProjectProperties {
    private String name;
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
