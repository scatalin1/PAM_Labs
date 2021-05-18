package com.cat.myapplication

import androidx.test.espresso.assertion.ViewAssertions.matches;
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.cat.myapplication.ui.MainActivity2
import org.junit.Rule
import org.junit.Test


class MyUiTest {
    private lateinit var string: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity2> = ActivityScenarioRule(MainActivity2::class.java)

    @Test
    @Throws(Exception::class)
    fun checkChangeOfText() {

        val testName = "purse"

        onView(withId(R.id.purse)).perform(typeText(testName)).check(matches(withText(testName)))
    }
}