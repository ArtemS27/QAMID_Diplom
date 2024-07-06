package ru.iteco.fmhandroid.ui.tests;



import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.pageobjects.SwitchTabs;
import ru.iteco.fmhandroid.ui.data.Data;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SwitchTabsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    Data data = new Data();
    Login logIn = new Login();
    SwitchTabs switchTabs = new SwitchTabs();

    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
    }

    @Test
    public void goToNewsTabFromMainTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
    }

    @Test
    public void goToAboutTabFromMainTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToAboutTab();
    }

    @Test
    public void goToMainTabFromNewsTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
        switchTabs.goToMainTab();
    }

    @Test
    public void goToAboutTabFromNewsTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
        switchTabs.goToAboutTab();
    }

}
