package com.udemy.automation.application.framework.serenitybdd;

import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Henry J. Calani A.
 */
abstract class BaseFactory {

    abstract ApplicationContext applicationContext();

    <T> void injectAutowired(T instance) {
        Map<Field, Class<?>> autowiredFields = loadAutowiredFields(instance.getClass());

        if (!autowiredFields.isEmpty()) {
            autowiredFields.keySet().forEach(field -> {
                Class<?> fieldClazz = autowiredFields.get(field);

                ReflectionUtils.makeAccessible(field);

                ReflectionUtils.setField(field, instance, applicationContext().getBean(fieldClazz));
            });
        }
    }

    private <T> Map<Field, Class<?>> loadAutowiredFields(final Class<T> clazz) {
        Map<Field, Class<?>> result = new HashMap<>();

        AutowiredFieldsLoader<T> loader = new AutowiredFieldsLoader<T>() {

            @Override
            Class<T> targetClazz() {
                return clazz;
            }

            @Override
            void register(Field field, Class<?> fieldClazz) {
                result.put(field, fieldClazz);
            }
        };

        loader.execute();

        return result;
    }
}
