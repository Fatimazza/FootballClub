package io.github.fatimazza.footballclub.home

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import io.github.fatimazza.footballclub.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteFragmentTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testTeamListBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.spinner))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.spinner)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Spanish La Liga")).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("Barcelona"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Barcelona")).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Added to favorite"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.favorites)).perform(ViewActions.click())
    }

}