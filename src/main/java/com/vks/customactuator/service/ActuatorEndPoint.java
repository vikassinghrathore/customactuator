package com.vks.customactuator.service;
import com.vks.customactuator.model.Information;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "appinfo")
public class ActuatorEndPoint {

    @Value("${spring.application.maven.version}")
    private String versionId;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.maven.artifactId}")
    private String artifactId;

    @ReadOperation
    public Information getApplicationInfo() {
        Information information = new Information();
        information.setApplicationName(applicationName);
        information.setVersionId(versionId);
        information.setArtifactId(artifactId);
        information.setStatus("Application status is running");
        return information;
    }
}
