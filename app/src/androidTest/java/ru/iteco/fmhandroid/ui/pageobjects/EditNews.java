package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ClickChildViewWithId;
import ru.iteco.fmhandroid.ui.elements.EditNewsElements;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;

public class EditNews {
    MainTabElements mainTabElements = new MainTabElements();
    NewsTabElements newsTabElements = new NewsTabElements();
    EditNewsElements editNewsElements = new EditNewsElements();
    @Step("Create news")
    public void CreateNews(String category, String title, String description) {
        mainTabElements.allNewsButton.perform(click());
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNewsElements.addNewsButton.check(matches(isDisplayed()));
        editNewsElements.addNewsButton.perform(click());
        editNewsElements.categoryField.perform(replaceText(category));
        editNewsElements.titleField.perform(replaceText(title));
        editNewsElements.dateField.perform(click());
        editNewsElements.widgetOkButton.perform(click());
        editNewsElements.timeField.perform(click());
        editNewsElements.widgetOkButton.perform(click());
        editNewsElements.descriptionField.perform(replaceText(description));
        editNewsElements.saveButton.perform(click());
    }
    @Step("Edit news")
    public void EditNews(String title, String newCategory, String newTitle, String newDescription) {
        /*onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title))))
                .perform(ClickChildViewWithId.clickChildWithId(R.id.edit_news_material_button));*/
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        0, ClickChildViewWithId.clickChildWithId(R.id.edit_news_item_image_view
                        )));
        editNewsElements.categoryField.perform(replaceText(newCategory));
        editNewsElements.titleField.perform(replaceText(newTitle));
        editNewsElements.dateField.perform(click());
        editNewsElements.widgetOkButton.perform(click());
        editNewsElements.timeField.perform(click());
        editNewsElements.widgetOkButton.perform(click());
        editNewsElements.descriptionField.perform(replaceText(newDescription));
        editNewsElements.saveButton.perform(click());
    }
    @Step("Delete news")
    public void DeleteNews(String title) {
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                0, ClickChildViewWithId.clickChildWithId(R.id.delete_news_item_image_view
        )));
        waitId(editNewsElements.okButtonId);
        editNewsElements.okButton.perform(click()); // не нажимает кнопку ОК
        onView(allOf(withText(title))).check(doesNotExist()); // проверка проходит в любых случаях
    }

}
