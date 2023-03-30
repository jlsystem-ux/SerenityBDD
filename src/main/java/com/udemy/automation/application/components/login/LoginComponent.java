package com.udemy.automation.application.components.login;

import com.udemy.automation.application.framework.context.PrototypeScope;
import lombok.Getter;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.annotation.PostConstruct;

/**
 * @author Henry J. Calani A.
 */
@PrototypeScope
class LoginComponent {

    @Getter
    private Target headerTitle;

    @Getter
    private Target emailLabel;

    @Getter
    private Target emailInput;

    @Getter
    private Target passwordLabel;

    @Getter
    private Target passwordInput;

    @Getter
    private Target loginButton;

    Performable enterEmailValue(String value) {
        return Enter.theValue(value).into(emailInput).thenHit(Keys.TAB);
    }

    Performable enterPasswordValue(String value) {
        return Enter.theValue(value).into(passwordInput).thenHit(Keys.TAB);
    }

    Performable pushLoginButton() {

        return Click.on(loginButton);
    }

    @PostConstruct
    void onPostConstruct() {

        headerTitle = Target.the(ConstantsLogin.TITLE_PAGE).located(By.cssSelector(ConstantsLogin.TITLE));
        emailLabel = Target.the(ConstantsLogin.EMAIL_LABEL).located(By.className(ConstantsLogin.EMAIL_SELECTOR));
        emailInput = Target.the(ConstantsLogin.EMAIL_LABEL_INPUT).located(By.id(ConstantsLogin.EMAIL_SELECTOR_INPUT));
        passwordLabel = Target.the(ConstantsLogin.PASSWORD_LABEL).located(By.className(ConstantsLogin.PASSWORD_SELECTOR));
        passwordInput = Target.the(ConstantsLogin.PASSWORD_LABEL_INPUT).located(By.id(ConstantsLogin.PASSWORD_SELECTOR_INPUT));
        loginButton = Target.the(ConstantsLogin.INPUT_SUBMIT).located(By.xpath(ConstantsLogin.INPUT_SUBMIT_SELECTOR));

    }
}
