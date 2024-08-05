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
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.elements.MainTabElements;
import ru.iteco.fmhandroid.ui.elements.NewsTabElements;
import ru.iteco.fmhandroid.ui.pageobjects.AboutPage;
import ru.iteco.fmhandroid.ui.pageobjects.EditNews;
import ru.iteco.fmhandroid.ui.pageobjects.Login;
import ru.iteco.fmhandroid.ui.pageobjects.SwitchTabs;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutAppTest {

        @Rule
        public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
                new ActivityScenarioRule<>(AppActivity.class);

        Data data = new Data();
        AboutPage aboutPage = new AboutPage();
        SwitchTabs switchTabs = new SwitchTabs();
        Login loginTest = new Login();

        @Before
        public void setUp() {
            loginTest.LogOutIfLoggedIn();
            loginTest.LoginTest(data.validLogin, data.validPassword);
            switchTabs.goToAboutTab();
        }

        @Test
        @DisplayName("Check About page visibility")
        public void checkVisibilityAboutPageTest() {
            aboutPage.checkVersionVisibility();
        }

        @Test
        @DisplayName("Check Privacy Policy link")
        public void checkPrivacyPolicyLink() {
            aboutPage.checkPrivacyPolicyIsClickable();
        }

        @Test
        @DisplayName("Check Terms of use link")
        public void checkTermsOfUseLink() {
            aboutPage.checkTermsOfUseIsClickable();
        }
}
