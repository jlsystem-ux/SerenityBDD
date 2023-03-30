package com.udemy.automation.application.framework.serenitybdd;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

/**
 * @author Henry J. Calani A.
 */
public abstract class TaskFactory extends BaseFactory {

    public <T extends Task> T create(Class<T> clazz) {
        T instance = Instrumented.instanceOf(clazz).newInstance();

        injectAutowired(instance);

        return instance;
    }
}
