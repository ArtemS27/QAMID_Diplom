package ru.iteco.fmhandroid.ui.tests;

import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DecorView;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.data.Data;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoginTest {

    DecorView decorView = new DecorView();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        decorView.setUp(mActivityScenarioRule);
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
    }

    Data data = new Data();
    Login loginTest = new Login();
    @Test
    @DisplayName("Login with valid login and password")
    public void loginWithValidLoginAndPasswordTest() {
        loginTest.LoginTest(data.validLogin, data.validPassword);
        loginTest.CheckIfLoggedIn();
    }

    @Test
    @DisplayName("Login with empty fields")
    public void loginWithEmptyFieldsTest() {
        loginTest.LoginTest(data.emptyLogin, data.emptyPassword);
        decorView.checkMessage(data.emptyFieldsMessage);
        }

    @Test
    @DisplayName("Login with invalid login")
    public void loginWithInvalidLogin() {
        loginTest.LoginTest(data.invalidLogin, data.validPassword);
        decorView.checkMessage(data.invalidLoginOrPasswordMessage);
    }

    @Test
    @DisplayName("Login with invalid password")
    public void loginWithInvalidPassword() {
        loginTest.LoginTest(data.validLogin, data.invalidPassword);
        decorView.checkMessage(data.invalidLoginOrPasswordMessage);
    }

    }
