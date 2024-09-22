package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class EditNewsElements {
    public int okButtonId = android.R.id.button1;
    public ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public ViewInteraction widgetOkButton = onView(withId(android.R.id.button1));
    public ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction okButton = onView(withText("OK"));

}
