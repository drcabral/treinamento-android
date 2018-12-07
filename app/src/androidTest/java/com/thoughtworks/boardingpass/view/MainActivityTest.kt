package com.thoughtworks.boardingpass.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.azimolabs.conditionwatcher.ConditionWatcher
import com.thoughtworks.boardingpass.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        onView(withId(R.id.recordLocatorEditText)).perform(replaceText("1"), closeSoftKeyboard())

        onView(withId(R.id.searchButton)).perform(click())

        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))

        ConditionWatcher.waitForCondition(ViewVisibleInstruction(activityTestRule.activity, R.id.progressBar, false))
        Thread.sleep(3000)

        onView(withId(R.id.qrcode_image)).check(matches(isDisplayed()))
    }

}
