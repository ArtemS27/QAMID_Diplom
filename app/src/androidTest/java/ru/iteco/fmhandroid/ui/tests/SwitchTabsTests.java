package ru.iteco.fmhandroid.ui.tests;



import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageobjects.AboutPage;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.pageobjects.SwitchTabs;
import ru.iteco.fmhandroid.ui.data.Data;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class SwitchTabsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    Data data = new Data();
    Login logIn = new Login();
    SwitchTabs switchTabs = new SwitchTabs();
    AboutPage aboutPage = new AboutPage();

    @Before
    public void setUp() {
        Login loginTest = new Login();
        loginTest.LogOutIfLoggedIn();
        logIn.LoginTest(data.validLogin, data.validPassword);
    }

    @Test
    @DisplayName("Switch Main tab to News tab")
    public void goToNewsTabFromMainTab() {
        switchTabs.goToNewsTab();
        switchTabs.checkNewsTab();
    }

    @Test
    @DisplayName("Switch Main tab to About tab")
    public void goToAboutTabFromMainTab() {
        switchTabs.goToAboutTab();
        aboutPage.checkVersionVisibility();
    }

    @Test
    @DisplayName("Switch News tab to Main tab")
    public void goToMainTabFromNewsTab() {
        switchTabs.goToNewsTab();
        switchTabs.goToMainTab();
        switchTabs.checkMainTab();
    }

    @Test
    @DisplayName("Switch News tab to About tab")
    public void goToAboutTabFromNewsTab() {
        switchTabs.goToNewsTab();
        switchTabs.goToAboutTab();
        aboutPage.checkVersionVisibility();
    }

    @Test
    @DisplayName("Switch to Our mission tab")
    public void goToOurMissionTab() {
        switchTabs.goToOurMissionPage();
        switchTabs.checkOurMissionPage();
    }

}
