package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var bmiResult: String = intent.getStringExtra("calculate result in first activity")

        bmiResultValue.text = bmiResult

        if (bmiResult.toDouble() < 18.5) {
            adviceLable.text = "Eat more pies!"
        } else if (bmiResult.toDouble() < 24.9) {
            adviceLable.text = "Fit as a fiddle!"
        } else {
            adviceLable.text = "Eat less pies!"
        }

        //TODO: onclick then back to first screen
        //btnRecalculate.setOnClickListener { dismiss }
    }
}
