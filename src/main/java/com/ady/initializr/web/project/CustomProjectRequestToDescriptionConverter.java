package com.ady.initializr.web.project;

import com.ady.initializr.generator.project.CustomProjectDescription;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.web.project.ProjectRequestToDescriptionConverter;

public class CustomProjectRequestToDescriptionConverter
        implements ProjectRequestToDescriptionConverter<CustomProjectRequest> {

    @Override
    public ProjectDescription convert(CustomProjectRequest request, InitializrMetadata metadata) {
        CustomProjectDescription description = new CustomProjectDescription();
        description.setDockerfile(request.isDockerfile());
        return description;
    }
}