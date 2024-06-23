package ru.iteco.fmhandroid.ui.tests;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageobjects.LogOut;
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
    LogOut logOut = new LogOut();
    SwitchTabs switchTabs = new SwitchTabs();

    @Test
    public void goToNewsTabFromMainTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
        logOut.LogOutTest();
    }

    @Test
    public void goToAboutTabFromMainTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToAboutTab();
        logOut.LogOutTest();
    }

    @Test
    public void goToMainTabFromNewsTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
        switchTabs.goToMainTab();
        logOut.LogOutTest();
    }

    @Test
    public void goToAboutTabFromNewsTab() {
        logIn.LoginTest(data.validLogin, data.validPassword);
        switchTabs.goToNewsTab();
        switchTabs.goToAboutTab();
        logOut.LogOutTest();
    }

}
