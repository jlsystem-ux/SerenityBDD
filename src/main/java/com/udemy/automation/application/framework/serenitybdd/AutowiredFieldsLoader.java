package com.udemy.automation.application.framework.serenitybdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author Henry J. Calani A.
 */
abstract class AutowiredFieldsLoader<T> {

    abstract Class<T> targetClazz();

    abstract void register(Field field, Class<?> fieldClazz);

    void execute() {
        ReflectionUtils.doWithFields(
                targetClazz(),
                field -> {
                    register(field, field.getType());
                },
                field -> field.isAnnotationPresent(Autowired.class)
        );
    }
}
