package ru.iteco.fmhandroid.ui.data;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import org.hamcrest.Matcher;

public class ClickChildViewWithId implements ViewAction {
    private final int viewId;

    public ClickChildViewWithId (int viewId) {
        this.viewId = viewId;
    }

    @Override
    public Matcher<View> getConstraints() {
        return ViewMatchers.isDisplayed();
    }

    @Override
    public String getDescription() {
        return "Click on a child view with specified id";
    }

    @Override
    public void perform (UiController uiController, View view) {
        View v = view.findViewById(viewId);
        v.performClick();
    }

    public static ViewAction clickChildWithId (int id) {
        return new ClickChildViewWithId(id);
    }
}
