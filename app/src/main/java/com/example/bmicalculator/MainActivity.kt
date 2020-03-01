package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //display dynamic height value
        seekBarHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightValue.text = progress.toString() + "cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //display dynamic weight value
        seekBarWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weightValue.text = progress.toString() + "kg"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnCalculate.setOnClickListener {
            calculatePressed(seekBarHeight.progress.toString(), seekBarWeight.progress.toString())
        }
    }

    private fun calculatePressed(height: String, weight: String) {
        val heightDouble = height.toDouble() / 100
        val bmi = weight.toDouble() / (heightDouble * heightDouble)
        val bmiResult = String.format("%.2f", bmi)

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("calculate result in first activity", bmiResult)
        startActivity(intent)
    }

}


