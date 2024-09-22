package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;

public class NewsTabElements {

    Data data = new Data();
    public int editNewsButtonId = R.id.edit_news_material_button;
    public int listOfNews = R.id.news_list_recycler_view;
    public ViewInteraction editNewsButton = onView(withId(editNewsButtonId));

    // need to make text to input into view interaction
    public ViewInteraction newsTitleText = onView(
            allOf(withId(R.id.news_item_title_text_view), withText(data.createNewsTitleText),
                    withParent(withParent(withId(R.id.news_item_material_card_view))),
                    isDisplayed()));

    public ViewInteraction newsEditedTitleText = onView(
            allOf(withId(R.id.news_item_title_text_view), withText(data.editNewsTitleText),
                    withParent(withParent(withId(R.id.news_item_material_card_view))),
                    isDisplayed()));
}
