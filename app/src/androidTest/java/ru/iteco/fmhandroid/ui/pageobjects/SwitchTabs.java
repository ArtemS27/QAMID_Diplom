package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

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
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.newsButton.check(matches(isDisplayed()));
        appElements.newsButton.perform(click());
        appElements.textNewsView.check(matches(isDisplayed()));
    }
    @Step("Go to About tab")
    public void goToAboutTab() {
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.aboutButton.perform(click());
        appElements.aboutTitle.check(matches(isDisplayed()));
        //appElements.aboutBackButton.perform(click());
    }
    @Step("Go to Main tab")
    public void goToMainTab() {
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.mainButton.perform(click());
    }
    @Step("Go to Our Mission tab")
    public void goToOurMissionPage() {
        waitId(R.id.main_menu_image_button);
        appElements.ourMissionButton.perform(click());
    }
    @Step("Check Main tab")
    public void checkMainTab() {
        mainTabElements.allNewsButton.check(matches(isDisplayed()));
    }
    @Step("Check News tab")
    public void checkNewsTab() {
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
    }
    @Step("Check Our mission tab")
    public void checkOurMissionPage() {
        appElements.ourMissionTitle.check(matches(isDisplayed()));
    }
}
