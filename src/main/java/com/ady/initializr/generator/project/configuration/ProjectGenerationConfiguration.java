package com.ady.initializr.generator.project.configuration;

import com.ady.initializr.web.project.CustomProjectRequest;
import com.ady.initializr.web.project.CustomProjectRequestToDescriptionConverter;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectGenerationConfiguration {

    @Bean
    public ProjectGenerationInvoker<CustomProjectRequest> projectGenerationInvoker(
            InitializrMetadataProvider metadataProvider,
            ApplicationContext applicationContext) {
        return new ProjectGenerationInvoker<>(
                applicationContext,
                new CustomProjectRequestToDescriptionConverter()
        );
    }
}