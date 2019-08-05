package com.dicoding.picodiploma.learnespresso;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sidiqpermana on 1/11/17.
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangeWork() {
        onView(withId(R.id.edt_text)).perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.btn_change_text)).perform(click());
        onView(withId(R.id.tv_printed_text)).check(matches(withText("Lalala")));
    }

    @Test
    public void ensureMoveActivityWithData() {
        onView(withId(R.id.edt_text)).perform(typeText("DicodingMenjadiAndroidDeveloperExpert"), closeSoftKeyboard());
        onView(withId(R.id.btn_swicth_activity)).perform(click());
        onView(withId(R.id.tv_result_view)).check(matches(withText("DicodingMenjadiAndroidDeveloperExpert")));
    }

}
