package com.udemy.automation.application.components.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Henry J. Calani A.
 */
public class TheLoginButtonExists implements Question<Boolean> {

    @Autowired
    private LoginComponent component;

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(component.getLoginButton()).viewedBy(actor).resolve();
    }
}
