package com.cat.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import com.cat.myapplication.ui.MainActivity
import com.cat.myapplication.ui.MainActivity2
import com.google.common.truth.Truth.*
import org.junit.Test

class ExampleUnitTest {


    private lateinit var scenarioMain: ActivityScenario<MainActivity>
    private lateinit var scenario: ActivityScenario<MainActivity2>

    private var mMainActivity: MainActivity2? = null

    fun NumberAdder(activity: MainActivity2?) {
        mMainActivity = activity
    }

    @Test
    fun createActivity() {
        val scenarioMain = launchActivity<MainActivity>()
    }

    @Test
    fun recreateActivityInCaseOfCrash() {
        val scenario = launchActivity<MainActivity2>()
        scenario.recreate()
        val originalActivityState = scenario.state
    }

    @Test
    fun validInputOfAddItemFun() {
        val name = "test"
        val amount = "123"
        val add = mMainActivity?.addItem(name, amount)
        assertThat(add).isEqualTo(null)
    }
}
