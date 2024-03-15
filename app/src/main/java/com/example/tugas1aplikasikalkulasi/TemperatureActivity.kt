package com.example.tugas1aplikasikalkulasi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class TemperatureActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnCelsius : CardView
    lateinit var btnFahrenheit : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var tvHasil : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCelsius = findViewById(R.id.buttonTemperatureCelsius)
        btnFahrenheit = findViewById(R.id.buttonTemperatureFahrenheit)
        btnkosong = findViewById(R.id.button_temperature_reset)
        etA = findViewById(R.id.et_temperature_a)
        tvHasil = findViewById(R.id.textTemperatureHasil)
        btnCelsius.setOnClickListener(this)
        btnFahrenheit.setOnClickListener(this)
        btnkosong.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when(v?.id){
            R.id.buttonTemperatureCelsius -> {
                celciusToFahrenheit()
            }
            R.id.buttonTemperatureFahrenheit -> {
                fahrenheitToCelcius()
            }
            R.id.button_temperature_reset -> {
                resetInput()
            }
        }
    }

    private fun celciusToFahrenheit() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            val a = a.toDouble()
            val hasil = (a*9/5)+32
            tvHasil.text = "Hasil : ${hasil}°F"
        } else {
            showToast(this, "Inputan tidak boleh kosong.")
        }
    }

    private fun fahrenheitToCelcius() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            val a = a.toDouble()
            val hasil = (5.0/9.0)*(a-32)
            tvHasil.text = "Hasil : ${hasil}°C"
        } else {
            showToast(this, "Inputan tidak boleh kosong.")
        }
    }

    private fun resetInput() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            etA.text.clear()
            tvHasil.text = "Hasil :"
        }else{

            showToast(this, "Inputan tidak boleh kosong.")
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}