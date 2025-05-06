package com.ady.initializr.contributor;

import com.ady.initializr.generator.project.CustomProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DockerfileContributor implements ProjectContributor {

    private final CustomProjectDescription description;

    public DockerfileContributor(CustomProjectDescription description) {
        this.description = description;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        if(description.isDockerfile()) {
            Path dockerfile = projectRoot.resolve("Dockerfile");
            String content = "FROM maven:3.9-eclipse-temurin-17 as builder\n" +
                    "WORKDIR /app\n" +
                    "COPY pom.xml .\n" +
                    "COPY src ./src\n" +
                    "RUN mvn clean package -DskipTests\n\n" +
                    "FROM openjdk:17-jdk-slim\n" +
                    "WORKDIR /app\n" +
                    "COPY --from=builder /app/target/*.jar app.jar\n" +
                    "EXPOSE 8080\n" +
                    "ENTRYPOINT [\"java\", \"-jar\", \"/app/app.jar\"]";

            Files.createDirectories(dockerfile.getParent());
            FileCopyUtils.copy(content.getBytes(), Files.newOutputStream(dockerfile));
        }
    }

    @Override
    public int getOrder() {
        return 50; // Ordre d'exécution dans la génération
    }
}
