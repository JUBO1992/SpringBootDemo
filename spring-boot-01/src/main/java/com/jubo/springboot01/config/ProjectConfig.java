package com.jubo.springboot01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/03/15
 */
@Component
public class ProjectConfig {

    @Value(value = "${project-config.system-name}")
    private String systemName;

    @Value(value = "${project-config.upload-path}")
    private String uploadPath;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

}
