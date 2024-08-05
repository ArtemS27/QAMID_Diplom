package ru.iteco.fmhandroid.ui.pageobjects;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutElements;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class AboutPage {
    AboutElements aboutElements = new AboutElements();
    @Step("Check version")
    public void checkVersionVisibility() {
        aboutElements.appVersion.check(matches(isDisplayed()));
    }
    @Step("Check Privacy Policy")
    public void checkPrivacyPolicyIsClickable() {
        aboutElements.privacyPolicyLink.check(matches(isClickable()));
    }
    @Step("Check Terms of use")
    public void checkTermsOfUseIsClickable() {
        aboutElements.termsOfUseLink.check(matches(isClickable()));
    }
}
