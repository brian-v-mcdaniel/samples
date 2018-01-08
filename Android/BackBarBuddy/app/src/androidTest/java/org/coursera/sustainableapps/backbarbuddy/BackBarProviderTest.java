package org.coursera.sustainableapps.backbarbuddy;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;
import android.util.Log;

import org.coursera.sustainableapps.backbarbuddy.provider.BackBarContract;
import org.coursera.sustainableapps.backbarbuddy.provider.BackBarProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.ContentValues.TAG;
import static org.coursera.sustainableapps.backbarbuddy.provider.BackBarProvider.BOTTLES;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Brian McDaniel on 11/6/2017.
 * Part of BackBar Buddy assignment.
 */

/*
 * This class tests the BackBarProvider using
 * ProviderTestCase2 to isolate the test code from the real user database.
 * Special thanks to Rohit Singh on medium.com.
 */

public class BackBarProviderTest extends ProviderTestCase2<BackBarProvider> {

    BackBarProvider bbpTest;
    Uri testUri;
    final static ContentValues testValues = new ContentValues();
    final static Instrumentation inst = new Instrumentation();

    public BackBarProviderTest() {
        super(BackBarProvider.class, BackBarContract.CONTENT_AUTHORITY);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    static final Uri[] validUris = new Uri[]{
            Uri.parse(BackBarContract.CONTENT_AUTHORITY +
                    BackBarContract.PATH_BOTTLE +
                    BOTTLES)
    };

    @Test
    public void testQuery() {
        ContentProvider provider = getProvider();
        assertNotNull(provider);
        for (Uri uri : validUris) {
            Cursor cursor = provider.query(BackBarContract.BottleEntry.CONTENT_URI,
                    BackBarContract.BottleEntry.sColumnsToDisplay,
                    BackBarContract.BottleEntry.COLUMN_NAME, null,
                    null);
            assertNotNull(cursor);
        }
    }


    /**
     * Try to query the database.
     */
    /*
    @Test
    public void queryDatabase() throws Exception {
            assertNotNull(inst);
            ContentResolver cr = inst.getContext().getContentResolver();
            assertNotNull(cr);
            for (Uri uri : validUris) {
                Cursor cursor = cr.query(uri, null, null, null, null);
                assertNotNull(cursor);
            }
    }
    */
}
