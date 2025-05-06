package com.ady.initializr.web.project;

import io.spring.initializr.web.project.WebProjectRequest;

public class CustomProjectRequest extends WebProjectRequest {
    private boolean dockerfile;

    public boolean isDockerfile() {
        return dockerfile;
    }

    public void setDockerfile(boolean dockerfile) {
        this.dockerfile = dockerfile;
    }
}
