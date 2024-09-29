package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocused;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.ClickChildViewWithId.clickChildWithId;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.elements.AppElements;

public class InteractionOnPages {

    Data data = new Data();
    AppElements appElements = new AppElements();

    @Step("Push hide/expand button all news")
    public void PushHideNewsButton() {
        Allure.step("Push hide/expand button all news");
        waitId(appElements.allNewsButtonId);
        onView(withId(appElements.allNewsButtonId)).check(matches(isDisplayed()));
        appElements.hideNewsButton.check(matches(isDisplayed()));
        appElements.hideNewsButton.perform(click());
        onView(withId(R.id.all_news_text_view)).check(matches(isNotFocused()));
        appElements.hideNewsButton.perform(click());
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
        }

        @Step("Push hide/expand button on one news")
        public void PushHideButtonOnNews() {
        Allure.step("Push hide/expand button on one news");
            appElements.newsExpandingButton.perform(actionOnItemAtPosition(0, click()));
            waitId(appElements.descriptionTextId);
            appElements.descriptionText.check(matches(isDisplayed()));
        }

        @Step("Filter news")
        public void FilterNews(String title) {
        Allure.step("Filter news");
        onView(withId(R.id.filter_news_material_button)).perform(click());
        onView(withId(R.id.news_item_category_text_auto_complete_text_view)).perform(replaceText(title));
        onView(withId(R.id.filter_button)).perform(click());
        }

        @Step("Check news are filtered")
        public void CheckIfNewsAreFiltered(String title) {
        Allure.step("Check if news are filtered");
            onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title)))).check(matches(isDisplayed()));
        }
}
