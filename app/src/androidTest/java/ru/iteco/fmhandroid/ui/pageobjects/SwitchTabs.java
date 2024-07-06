package ru.iteco.fmhandroid.ui.pageobjects;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AppElements;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SwitchTabs {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    AppElements appElements = new AppElements();
    @Test
    public void goToNewsTab() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }*/
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.newsButton.check(matches(isDisplayed()));
        appElements.newsButton.perform(click());
        appElements.textNewsView.check(matches(isDisplayed()));
    }

    @Test
    public void goToAboutTab() {
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.aboutButton.perform(click());
        appElements.aboutTitle.check(matches(isDisplayed()));
        appElements.aboutBackButton.perform(click());
    }

    @Test
    public void goToMainTab() {
        waitId(R.id.main_menu_image_button);
        appElements.mainMenuButton.perform(click());
        appElements.mainButton.perform(click());
    }
}
