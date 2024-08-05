package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.doesNotHaveFocus;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.core.internal.deps.desugar.ThrowableExtension;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;
import ru.iteco.fmhandroid.ui.pageobjects.EditNews;
import ru.iteco.fmhandroid.ui.pageobjects.Login;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsEditTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    Data data = new Data();
    MainTabElements mainTabElements = new MainTabElements();
    NewsTabElements newsTabElements = new NewsTabElements();
    EditNews editNews = new EditNews();

    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
        loginTest.LoginTest(data.validLogin, data.validPassword);
    }

    @Test
    @DisplayName("Create news")
    public void createNewNewsTest() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews1, data.createNewsTitleText, data.createNewsDescriptionText);
        newsTabElements.newsTitleText.check(matches(withText(data.createNewsTitleText)));
        editNews.DeleteNews(data.createNewsTitleText);
    }


    @Test
    @DisplayName("Edit news")
    public void editNewsTest() {
        waitId(mainTabElements.allNewsButtonId);
        editNews.CreateNews(data.categoryNews1, data.createNewsTitleText, data.createNewsDescriptionText);
        newsTabElements.newsTitleText.check(matches(withText(data.createNewsTitleText)));
        editNews.EditNews(data.createNewsTitleText, data.categoryNews1, data.editNewsTitleText, data.createNewsDescriptionText);
        newsTabElements.newsTitleText.check(matches(withText(data.editNewsTitleText))); // look into news tab elements
        editNews.DeleteNews(data.editNewsTitleText);
    }
}
