package com.udemy.automation.application.framework.serenitybdd;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Henry J. Calani A.
 */
@Component("SetSerenityBDDFactoriesProducer")
class FactoriesProducer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    @Scope("prototype")
    public TaskFactory taskFactory() {
        return new TaskFactory() {

            @Override
            ApplicationContext applicationContext() {
                return applicationContext;
            }
        };
    }

    @Bean
    @Scope("prototype")
    public QuestionFactory questionFactory() {
        return new QuestionFactory() {

            @Override
            ApplicationContext applicationContext() {
                return applicationContext;
            }
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
