package org.coursera.sustainableapps.backbarbuddy;

/**
 * Created by Brian McDaniel on 11/6/2017.
 * Part of BackBar Buddy assignment.
 */

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.coursera.sustainableapps.backbarbuddy.activities.AddActivity;
import org.coursera.sustainableapps.backbarbuddy.activities.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Espresso UI tests go here.
 */

@RunWith(AndroidJUnit4.class)
public class AddBottleInstrumentedTest {
    private AddActivity mAddTestActivity;

    @Rule
    public ActivityTestRule<AddActivity> mAddActivityRule = new ActivityTestRule<>(
            AddActivity.class);

    @Before
    public void setUpAdd() {
        mAddTestActivity = mAddActivityRule.getActivity();
    }

    @Test
    public void testAddBottle() {
        /*
        onView(withId(R.id.amtAdd)).perform(typeText("1"));
        onView(withId(R.id.nameAdd)).perform(typeText("Jim Beam"));
        onView(withId(R.id.typeAdd)).perform(typeText("bourbon"));
        onView(withId(R.id.categoryAdd)).perform(typeText("whiskey"));
        onView(withId(R.id.sizeAdd)).perform(typeText("750 mL"));
        onView(withId(R.id.makerAdd)).perform(typeText("Jim Beam"));
        onView(withId(R.id.addOk)).perform(click());
        */
    }

    @After
    public void tearDownAdd() throws Exception {
        mAddTestActivity = null;
    }
}