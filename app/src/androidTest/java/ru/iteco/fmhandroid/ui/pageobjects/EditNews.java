package ru.iteco.fmhandroid.ui.pageobjects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;
import static ru.iteco.fmhandroid.ui.data.ClickChildViewWithId.clickChildWithId;

import android.os.SystemClock;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ClickChildViewWithId;
import ru.iteco.fmhandroid.ui.data.DecorView;
import ru.iteco.fmhandroid.ui.elements.EditNewsElements;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;

public class EditNews {
    MainTabElements mainTabElements = new MainTabElements();
    NewsTabElements newsTabElements = new NewsTabElements();
    EditNewsElements editNewsElements = new EditNewsElements();
    @Step("Create news")
    public void CreateNews(String category, String title, String description) {
        Allure.step("Create news");
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

    @Step("Find news by title")
    public void FindNewsByTitle (String title) {
        Allure.step("Find news by title");
        waitId(newsTabElements.listOfNews);
        onView(withId(newsTabElements.listOfNews)).check(matches(isDisplayed())).perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(title)))));
        onView(withId(newsTabElements.listOfNews)).check(matches(isDisplayed()));
    }

    @Step("Edit news")
    public void EditNews(String title, String newCategory, String newTitle, String newDescription) {
        Allure.step("Edit news");
        FindNewsByTitle(title);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title)))).perform(clickChildWithId(R.id.edit_news_item_image_view));
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
        Allure.step("Delete news");
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title)))).perform(clickChildWithId(R.id.delete_news_item_image_view));
        ClickOkButton();
    }

    @Step("Confirm delete")
    public void ClickOkButton() {
        Allure.step("Click 'OK' in the message");
        //waitId(editNewsElements.okButtonId);
        //  waitDisplayed(editNewsElements.okButtonId, 5000);
        SystemClock.sleep(1000);
        editNewsElements.okButton.perform(click());
    }

    @Step("Check if the news is deleted")
    public void CheckIfTheNewsDeleted(String title) {
        Allure.step("Check if the news is deleted");
        SystemClock.sleep(1000);
        onView(allOf(withText(title), isDisplayed())).check(doesNotExist());
    }

    @Step("Create news with empty fields")
    public void CreateNewsWithEmptyFields() {
        Allure.step("Create news with empty fields");
        mainTabElements.allNewsButton.perform(click());
        newsTabElements.editNewsButton.check(matches(isDisplayed()));
        newsTabElements.editNewsButton.perform(click());
        editNewsElements.addNewsButton.check(matches(isDisplayed()));
        editNewsElements.addNewsButton.perform(click());
        editNewsElements.saveButton.perform(click());
    }

}
