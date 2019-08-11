package ru.leonidivankin.photoapp_mvvm.view;


import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.leonidivankin.photoapp_mvvm.R;
import ru.leonidivankin.photoapp_mvvm.idlingResource.EspressoIdlingResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SingleActivityTest {

    @Rule
    public ActivityTestRule<SingleActivity> activityTestRule = new ActivityTestRule<>(SingleActivity.class);

    @Before
    public void before() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    @After
    public void after() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void singleActivityTest() {
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.recycler_view_fragment_main), isDisplayed()));
        appCompatImageView.perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }
}
