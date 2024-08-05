package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainTabElements {
    public int allNewsButtonId = R.id.all_news_text_view;
    public ViewInteraction allNewsButton = onView(withId(allNewsButtonId));
}
