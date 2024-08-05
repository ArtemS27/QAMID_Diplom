package ru.iteco.fmhandroid.ui.pageobjects;


import static androidx.test.espresso.action.ViewActions.*;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.AppElements;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;


public class LogOut {
    AppElements appElements = new AppElements();
    @Step("Logout")
    public void LogOutTest() {
        waitId(R.id.authorization_image_button);
        appElements.authorizationButton.perform(click());
        appElements.logOutButton.perform(click());
    }
}
