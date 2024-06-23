package ru.iteco.fmhandroid.ui.pageobjects;


import androidx.test.espresso.ViewInteraction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AppElements;
import ru.iteco.fmhandroid.ui.elements.AuthElements;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;


public class LogOut {

    AuthElements authElements = new AuthElements();
    AppElements appElements = new AppElements();
    public void LogOutTest() {
        waitId(R.id.authorization_image_button);
        appElements.authorizationButton.perform(click());
        // При первичной авторизации не может произвести click() если пользователь был авторизован но сначала получается выйти, а во второй раз нет.
        appElements.logOutButton.perform(click());
    }

    public void CheckIfLoggedOut() {
        authElements.logInButton.check(matches(isDisplayed()));
    }

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
