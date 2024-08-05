package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.ui.AppActivity;

public class DecorView {

    public View decorView;

    public void setUp(ActivityScenarioRule<AppActivity> appActivity) {
        appActivity.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    public void checkMessage (String message) {
        onView(withText(message)).inRoot(withDecorView(Matchers.not(decorView))).check(matches(isDisplayed()));
    }
}
