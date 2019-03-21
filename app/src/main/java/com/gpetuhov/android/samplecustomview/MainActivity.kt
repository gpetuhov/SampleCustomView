package com.gpetuhov.android.samplecustomview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var colorChange = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Our custom view has setValueColor method, so we can call it
        view1.setOnClickListener { view1.setValueColor(getNextColor(Color.RED)) }
        view2.setOnClickListener { view2.setValueColor(getNextColor(Color.BLUE)) }
    }

    private fun getNextColor(color: Int): Int {
        val result = color + colorChange
        colorChange += 100
        return result
    }
}
