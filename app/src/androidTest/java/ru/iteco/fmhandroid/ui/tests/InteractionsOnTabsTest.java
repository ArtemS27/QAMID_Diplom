package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AppElements;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.data.Data;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class InteractionsOnTabsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    Data data = new Data();
    AppElements appElements = new AppElements();
    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
        loginTest.LoginTest(data.validLogin, data.validPassword);
    }

    @Test
    @DisplayName("Interaction with news on the Main tab")
    public void interactionWithNewsOnMainTabTest() {
        waitId(R.id.all_news_text_view);
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
        ViewInteraction hideNewsButton = onView(withId(R.id.expand_material_button));
        hideNewsButton.check(matches(isDisplayed()));
        hideNewsButton.perform(click());
        onView(withId(R.id.all_news_text_view)).check(matches(isNotFocused()));
        hideNewsButton.perform(click());
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
        //onView(withId(R.id.news_item_description_text_view)).check(matches(isNotFocused()));
        appElements.newsExpandingButton.perform(click());
        onData(withId(R.id.news_item_description_text_view)).atPosition(0).perform(click());// не могу найти текст элемента
        //appElements.newsTextElement.check(matches(isDisplayed()));
        appElements.newsExpandingButton.perform(click());
        //onView(withId(R.id.news_item_description_text_view)).check(matches(isNotFocused()));
    }

}
