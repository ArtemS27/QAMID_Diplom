package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import android.os.SystemClock;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AppElements;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;
import ru.iteco.fmhandroid.ui.pageobjects.EditNews;
import ru.iteco.fmhandroid.ui.pageobjects.InteractionOnPages;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.data.Data;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageobjects.SwitchTabs;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class InteractionsOnTabsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    Data data = new Data();
    AppElements appElements = new AppElements();
    InteractionOnPages interaction = new InteractionOnPages();
    SwitchTabs switchTabs = new SwitchTabs();
    EditNews editNews = new EditNews();
    MainTabElements mainTabElements = new MainTabElements();
    NewsTabElements newsTabElements = new NewsTabElements();
    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
        loginTest.LoginTest(data.validLogin, data.validPassword);
    }

    @Test
    @DisplayName("Interaction with news on the Main tab")
    public void interactionWithNewsOnMainTabTest() {
        interaction.PushHideNewsButton();
        interaction.PushHideButtonOnNews();
    }

    @Test
    @DisplayName("Filter news 'Объявления'")
    public void filterNewsNotification() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews1, data.categoryNews1, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews1);
        interaction.CheckIfNewsAreFiltered(data.categoryNews1);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews1);
    }

    @Test
    @DisplayName("Filter news 'День рождения'")
    public void filterNewsBirthDay() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews2, data.categoryNews2, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews2);
        interaction.CheckIfNewsAreFiltered(data.categoryNews2);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews2);
    }

    @Test
    @DisplayName("Filter news 'Зарплата'")
    public void filterNewsSalary() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews3, data.categoryNews3, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews3);
        interaction.CheckIfNewsAreFiltered(data.categoryNews3);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews3);
    }

    @Test
    @DisplayName("Filter news 'Профсоюз'")
    public void filterNewsUnion() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews4, data.categoryNews4, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews4);
        interaction.CheckIfNewsAreFiltered(data.categoryNews4);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews4);
    }

    @Test
    @DisplayName("Filter news 'Праздник'")
    public void filterNewsEvent() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews5, data.categoryNews5, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews5);
        interaction.CheckIfNewsAreFiltered(data.categoryNews5);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews5);
    }

    @Test
    @DisplayName("Filter news 'Массаж'")
    public void filterNewsMassage() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews6, data.categoryNews6, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews6);
        interaction.CheckIfNewsAreFiltered(data.categoryNews6);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews6);
    }

    @Test
    @DisplayName("Filter news 'Благодарность'")
    public void filterNewsThanks() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews7, data.categoryNews7, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews7);
        interaction.CheckIfNewsAreFiltered(data.categoryNews7);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews7);
    }

    @Test
    @DisplayName("Filter news 'Нужна помощь'")
    public void filterNewsNeedHelp() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews8, data.categoryNews8, data.createNewsDescriptionText);
        switchTabs.goToNewsTab();
        interaction.FilterNews(data.categoryNews8);
        interaction.CheckIfNewsAreFiltered(data.categoryNews8);
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNews.DeleteNews(data.categoryNews8);
    }
}
