package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.isFocused;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AppElements;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;

public class SwitchTabs {

    AppElements appElements = new AppElements();
    MainTabElements mainTabElements = new MainTabElements();
    NewsTabElements newsTabElements = new NewsTabElements();
    @Step("Go to News tab")
    public void goToNewsTab() {
        Allure.step("Switch to 'news' tab");
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.newsButton.check(matches(isDisplayed()));
        appElements.newsButton.perform(click());
        appElements.textNewsView.check(matches(isDisplayed()));
    }
    @Step("Go to About tab")
    public void goToAboutTab() {
        Allure.step("Switch to 'about' tab");
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.aboutButton.check(matches(isDisplayed()));
        appElements.aboutButton.perform(click());
        appElements.aboutTitle.check(matches(isDisplayed()));
    }
    @Step("Go to Main tab")
    public void goToMainTab() {
        Allure.step("Switch to 'main' tab");
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.mainButton.perform(click());
    }
    @Step("Go to Our Mission tab")
    public void goToOurMissionPage() {
        Allure.step("Switch to 'our mission' tab");
        waitId(R.id.main_menu_image_button);
        appElements.ourMissionButton.perform(click());
    }
    @Step("Check Main tab")
    public void checkMainTab() {
        Allure.step("Check if 'main' tab is displayed");
        mainTabElements.allNewsButton.check(matches(isDisplayed()));
    }
    @Step("Check News tab")
    public void checkNewsTab() {
        Allure.step("Check if 'news' tab is displayed");
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
    }
    @Step("Check Our mission tab")
    public void checkOurMissionPage() {
        Allure.step("Check if 'about' tab is displayed");
        appElements.ourMissionTitle.check(matches(isDisplayed()));
    }
}
