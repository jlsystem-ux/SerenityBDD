package com.udemy.automation.test;

import com.udemy.automation.application.Config;
import com.udemy.automation.application.framework.serenitybdd.QuestionFactory;
import com.udemy.automation.application.framework.serenitybdd.TaskFactory;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Henry J. Calani A.
 */
@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(
        classes = {Config.class}
)
public abstract class AbstractTest {

    @Managed(driver = "chrome", uniqueSession = true)
    private WebDriver webDriver;

    @Autowired
    private TaskFactory taskFactory;

    @Autowired
    private QuestionFactory questionFactory;

    @BeforeClass
    public static void onBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
    }

    protected void initializeActor(Actor actor) {
        actor.can(BrowseTheWeb.with(webDriver));
    }

    protected <T extends Task> T taskInstance(Class<T> clazz) {
        return taskFactory.create(clazz);
    }

    protected <T extends Question> T questionInstance(Class<T> clazz) {
        return questionFactory.create(clazz);
    }
}
