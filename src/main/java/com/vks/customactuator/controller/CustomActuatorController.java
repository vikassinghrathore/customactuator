package com.vks.customactuator.controller;

import com.vks.customactuator.model.Information;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RestControllerEndpoint(id = "restAppInfo")
public class CustomActuatorController {

    @Value("${spring.application.maven.version}")
    private String versionId;
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.maven.artifactId}")
    private String artifactId;

    @GetMapping("/app")
    public Information getApplicationInformation() {
        Information information = new Information();
        information.setApplicationName(applicationName);
        information.setVersionId(versionId);
        information.setArtifactId(artifactId);
        information.setStatus("Application status is running");
        return information;
    }
}
