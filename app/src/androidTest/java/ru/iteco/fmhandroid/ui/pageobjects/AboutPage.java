package ru.iteco.fmhandroid.ui.pageobjects;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutElements;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class AboutPage {
    AboutElements aboutElements = new AboutElements();
    @Step("Check version")
    public void checkVersionVisibility() {
        Allure.step("Check version");
        aboutElements.appVersion.check(matches(isDisplayed()));
    }
    @Step("Check Privacy Policy")
    public void checkPrivacyPolicyIsClickable() {
        Allure.step("Check Privacy Policy");
        aboutElements.privacyPolicyLink.check(matches(isClickable()));
    }
    @Step("Check Terms of use")
    public void checkTermsOfUseIsClickable() {
        Allure.step("Check Terms of use");
        aboutElements.termsOfUseLink.check(matches(isClickable()));
    }
}
