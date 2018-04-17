package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void getJokeTest_verifyService() {
        String joke;
        try {
            joke = new EndpointsAsyncTask(null)
                    .execute()
                    .get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            fail("server is out");
            return;
        }

        assertThat("task return joke as null",
                joke, notNullValue());
        assertTrue("task return joke as empty",
                joke.length() > 0);
        assertTrue("task return joke as a server error",
                joke.length() < 9);
    }
}
