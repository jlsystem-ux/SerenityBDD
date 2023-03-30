package com.udemy.automation.test;

import com.udemy.automation.application.components.browser.OpenBrowser;
import com.udemy.automation.application.components.login.TheEmailInputExists;
import com.udemy.automation.application.components.login.TheHeaderTitle;
import com.udemy.automation.application.components.login.TheLoginButtonExists;
import com.udemy.automation.application.components.login.ThePasswordInputExists;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;

/**
 * @author Henry J. Calani A.
 */
public class OpenApplicationTest extends AbstractTest {

    private Actor actor = Actor.named("henry");

    private OpenBrowser openBrowser;

    private TheHeaderTitle theHeaderTitle;

    private TheLoginButtonExists theLoginButtonExists;

    private TheEmailInputExists theEmailInputExists;

    private ThePasswordInputExists thePasswordInputExists;

    @Before
    public void setup() {
        initializeActor(actor);

        openBrowser = taskInstance(OpenBrowser.class);

        theHeaderTitle = questionInstance(TheHeaderTitle.class);

        theLoginButtonExists = questionInstance(TheLoginButtonExists.class);

        theEmailInputExists = questionInstance(TheEmailInputExists.class);

        thePasswordInputExists = questionInstance(ThePasswordInputExists.class);
    }

    @WithTag("openAplication")
    @Test
    public void userOpenApplication() {
        givenThat(actor)
                .attemptsTo(openBrowser);

        then(actor).should(
                seeThat(theHeaderTitle, is("GitLab.com")),
                seeThat(theEmailInputExists),
                seeThat(thePasswordInputExists),
                seeThat(theLoginButtonExists)
        );
    }
}
