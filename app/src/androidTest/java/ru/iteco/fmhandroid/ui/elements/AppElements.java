package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.isNotClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isNotFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class AppElements {
    public int authorizationButtonId = R.id.authorization_image_button;

    public ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction ourMissionTitle = onView(withId(R.id.our_mission_title_text_view));

    public ViewInteraction authorizationButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOutButton = onView(
            allOf(withId(android.R.id.title), withText("Log out"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0),
                    isDisplayed()));

    public ViewInteraction mainMenuButton = onView(
            withId(R.id.main_menu_image_button));

    public ViewInteraction newsButton = onView(
            allOf(withId(android.R.id.title), withText("News"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0),
                    isDisplayed()));

    public ViewInteraction textNewsView = onView(
            allOf(withText("News"),
                    withParent(withParent(withId(R.id.container_list_news_include))),
                    isDisplayed()));

    public ViewInteraction aboutButton = onView(
            allOf(withId(android.R.id.title), withText("About"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0),
                    isDisplayed()));

    public ViewInteraction aboutTitle = onView(
            allOf(withId(R.id.about_version_title_text_view), withText("Version:"),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                    isDisplayed()));

    public ViewInteraction aboutBackButton = onView(
            allOf(withId(R.id.about_back_image_button),
                    childAtPosition(
                            allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            0)),
                            1),
                    isDisplayed()));

    public ViewInteraction mainButton = onView(
            allOf(withId(android.R.id.title), withText("Main"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0),
                    isDisplayed()));

    public ViewInteraction newsExpandingButton = onView(
            allOf(withId(R.id.news_list_recycler_view),
                    childAtPosition(
                            withId(R.id.all_news_cards_block_constraint_layout),
                            0)));

    public ViewInteraction newsTextElement = onView(
            anyOf(withId(R.id.news_item_description_text_view)));

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
