package com.example.kaiyizhang.mykotlin.core.platform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kaiyizhang.mykotlin.R.id
import com.example.kaiyizhang.mykotlin.R.layout
import com.example.kaiyizhang.mykotlin.core.extension.inTransaction
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_layout)
        setSupportActionBar(toolbar)
        addFragment(savedInstanceState)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                id.fragmentContainer) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState ?: supportFragmentManager.inTransaction { add(
                    id.fragmentContainer, fragment()) }

    abstract fun fragment(): BaseFragment
}
