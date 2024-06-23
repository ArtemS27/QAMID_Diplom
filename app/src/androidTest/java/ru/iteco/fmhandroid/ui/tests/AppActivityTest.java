package ru.iteco.fmhandroid.ui.tests;

import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageobjects.LogOut;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.data.Data;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
    }

    Data data = new Data();
    Login loginTest = new Login();
    LogOut logOut = new LogOut();
    @Test
    public void appActivityTest() {
        loginTest.LoginTest(data.validLogin, data.validPassword);
        loginTest.CheckIfLoggedIn();
        logOut.LogOutTest();
        logOut.CheckIfLoggedOut();
    }
    }
