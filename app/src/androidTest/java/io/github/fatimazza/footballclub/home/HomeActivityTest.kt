package io.github.fatimazza.footballclub.home

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import io.github.fatimazza.footballclub.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun TestRecyclerViewBehaviour() {
        onView(withId(list_team))
                .check(matches(isDisplayed()))
        onView(withId(list_team))
                .perform(RecyclerViewActions
                        .scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(list_team))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
    }
    
}