package com.ady.initializr.web.project;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class CustomProjectGenerationController extends ProjectGenerationController<CustomProjectRequest> {

    public CustomProjectGenerationController(
            InitializrMetadataProvider metadataProvider,
            ProjectGenerationInvoker<CustomProjectRequest> projectGenerationInvoker) {
        super(metadataProvider, projectGenerationInvoker);
    }

    @Override
    public CustomProjectRequest projectRequest(Map<String, String> headers) {
        CustomProjectRequest request = new CustomProjectRequest();
        request.setDockerfile(Boolean.parseBoolean(headers.get("dockerfile")));
        request.getParameters().putAll(headers);
        request.initialize(getMetadata());
        return request;
    }
}