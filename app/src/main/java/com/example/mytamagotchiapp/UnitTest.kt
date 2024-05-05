package com.example.mytamagotchiapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTwoTest {

    @get:Rule
    val activityRule = ActivityTestRule(ActivityTwo::class.java)

    @Test
    fun clickingFeedButton_updatesHungerLevel() {
        // Click on the feed button
        onView(withId(R.id.feedButton)).perform(click())

        // Check if the hunger level text view is updated
        onView(withId(R.id.hungerLevel)).check(matches(withText("25")))
    }

    @Test
    fun clickingCleanButton_updatesCleanlinessLevel() {
        // Click on the clean button
        onView(withId(R.id.cleanButton)).perform(click())

        // Check if the cleanliness level text view is updated
        onView(withId(R.id.cleanlinessLevel)).check(matches(withText("25")))
    }

    @Test
    fun clickingPlayButton_updatesHappinessLevel() {
        // Click on the play button
        onView(withId(R.id.playButton)).perform(click())

        // Check if the happiness level text view is updated
        onView(withId(R.id.happinessLevel)).check(matches(withText("25")))
    }
}
