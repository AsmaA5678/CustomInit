package com.ady.initializr.generator.project;

import io.spring.initializr.generator.project.MutableProjectDescription;

public class CustomProjectDescription extends MutableProjectDescription {
    private boolean dockerfile;

    public boolean isDockerfile() {
        return dockerfile;
    }

    public void setDockerfile(boolean dockerfile) {
        this.dockerfile = dockerfile;
    }
}