package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class FirstTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testName() {
        ViewInteraction mainText = onView(
                withId(R.id.text_home)
        );
        mainText.check(
                matches(
                        withText("This is home fragment")
                )
        );
    }

    @Test
    public void checkSlideShow() {
        ViewInteraction appCompatImageButton = onView(
                withContentDescription("Open navigation drawer"));
        appCompatImageButton.check(matches((isDisplayed())));
        appCompatImageButton.perform(click());
        ViewInteraction menuItems = onView(
                withId(R.id.nav_slideshow));
        menuItems.check(matches(isDisplayed()));
        menuItems.perform(click());
        ViewInteraction mainText = onView(
                withId(R.id.text_slideshow)
        );
        mainText.check(
                matches(
                        withText("This is slideshow fragment")
                )
        );
    }
}
