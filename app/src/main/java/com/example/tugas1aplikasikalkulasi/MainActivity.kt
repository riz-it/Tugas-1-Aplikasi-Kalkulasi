package com.example.tugas1aplikasikalkulasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnCalculator: CardView
    private lateinit var btnCircle: CardView
    private lateinit var btnRectangle: CardView
    private lateinit var btnTemperature: CardView
    private lateinit var btnUnit: CardView
    private lateinit var btnNumber: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculator = findViewById(R.id.buttonCalculator)
        btnCircle = findViewById(R.id.buttonCircular)
        btnRectangle = findViewById(R.id.buttonRectangle)
        btnUnit = findViewById(R.id.buttonUnit)
        btnNumber = findViewById(R.id.buttonNumber)
        btnTemperature = findViewById(R.id.buttonTemperature)

        btnCalculator.setOnClickListener(this)
        btnUnit.setOnClickListener(this)
        btnCircle.setOnClickListener(this)
        btnRectangle.setOnClickListener(this)
        btnTemperature.setOnClickListener(this)
        btnNumber.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonCalculator -> {
                val intentBiasa = Intent(this@MainActivity, CalculatorActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.buttonTemperature -> {
                val intentBiasa = Intent(this@MainActivity, TemperatureActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.buttonNumber -> {
                val intentBiasa = Intent(this@MainActivity, NumberActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.buttonUnit -> {
                val intentBiasa = Intent(this@MainActivity, UnitActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.buttonRectangle -> {
                val intentBiasa = Intent(this@MainActivity, RectangleActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.buttonCircular -> {
                val intentBiasa = Intent(this@MainActivity, CircularActivity::class.java)
                startActivity(intentBiasa)
            }
        }
    }
}
