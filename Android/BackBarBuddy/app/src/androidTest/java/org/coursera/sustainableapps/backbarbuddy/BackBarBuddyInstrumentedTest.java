package org.coursera.sustainableapps.backbarbuddy;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

import org.coursera.sustainableapps.backbarbuddy.activities.AddActivity;
import org.coursera.sustainableapps.backbarbuddy.activities.MainActivity;
import org.coursera.sustainableapps.backbarbuddy.provider.BackBarContract;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/**
 * Espresso UI tests go here.
 */

@RunWith(AndroidJUnit4.class)
public class BackBarBuddyInstrumentedTest {
    private MainActivity mTestActivity;

    /*
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("org.coursera.sustainableapps.backbarbuddy", appContext.getPackageName());
    }
    */

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() {
        mTestActivity = mActivityRule.getActivity();
        InstrumentationRegistry.getContext();
    }

    /**
     * Test each button.
     */
    @Test
    public void testSearch() {
        onView(withId(R.id.search)).perform(click());
        onView(withId(R.id.searchCancel)).perform(click());
    }

    @Test
    public void testAdd() {
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.addCancel)).perform(click());
    }

    /*
    @Test
    public void testModify() {
        onView(withId(R.id.modify)).perform(click());
        onView(withId(R.id.modifyCancel)).perform(click());
    }

    @Test
    public void testDelete() {
        onView(withId(R.id.delete)).perform(click());
        onView(withId(R.id.deleteCancel)).perform(click());
    }
    */

    @Test
    public void testSettings() {
        onView(withId(R.id.settings)).perform(click());
        onView(withId(R.id.settingsBack)).perform(click());
    }

    @Test
    public void testAddDefaults() {
        onView(withId(R.id.add_defaults)).perform(click());
    }

    @Test
    public void testDeleteAll() {
        onView(withId(R.id.delete_all)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        mTestActivity = null;
    }
}
