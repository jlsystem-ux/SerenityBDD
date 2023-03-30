package com.udemy.automation.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Henry J. Calani A.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Getter
    @Value("${app.url}")
    private String url;

    @Getter
    @Value("${app.url.calculator}")
    private String urlCalculator;

    @Getter
    @Value("${app.url.moodle}")
    private String urlMoodle;

    @Getter
    @Value("${user.messaging}")
    private String user;

    @Getter
    @Value("${password.messaging}")
    private String password;

    @Getter
    @Value("${first.value}")
    private String firstValue;

    @Getter
    @Value("${second.value}")
    private String secondValue;

    @Getter
    @Value("${user.moodle}")
    private String userMoodle;

    @Getter
    @Value("${password.moodle}")
    private String passwordMoodle;

    public String getUrl() {
        return url;
    }
}
