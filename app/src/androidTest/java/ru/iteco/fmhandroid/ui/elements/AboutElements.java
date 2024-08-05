package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutElements {
    public ViewInteraction appVersion = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
}
