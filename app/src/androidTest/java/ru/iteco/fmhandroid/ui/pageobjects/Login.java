package ru.iteco.fmhandroid.ui.pageobjects;


import androidx.test.espresso.NoMatchingViewException;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static ru.iteco.fmhandroid.ui.data.WaitObjectDisplayed.waitId;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DecorView;
import ru.iteco.fmhandroid.ui.elements.AuthElements;



public class Login {
    AuthElements authElements = new AuthElements();
    @Step("Login")
    public void LoginTest(String login, String password) {
        waitId(R.id.enter_button);

        authElements.logInElement.check(matches(isDisplayed()));
        authElements.logInElement.perform(replaceText(login), closeSoftKeyboard());

        authElements.passwordElement.check(matches(isDisplayed()));
        authElements.passwordElement.perform(replaceText(password), closeSoftKeyboard());

        authElements.logInButton.perform(click());
    }
    @Step("Check Login")
    public void CheckIfLoggedIn() {
        waitId(R.id.authorization_image_button);
    }
    @Step("Logout if Logged in")
    public void LogOutIfLoggedIn() {

        if(loggedIn()) {
            LogOut logOut = new LogOut();
            logOut.LogOutTest();
        }
    }
    public boolean loggedIn() {
        boolean logged = false;
        try {
            waitId(R.id.authorization_image_button);
            authElements.logInElement.check(matches(isDisplayed()));
            logged = false;
            return logged;
        } catch (NoMatchingViewException e) {
            logged = true;
            return logged;
        } finally {
            return logged;
        }
    }
}
