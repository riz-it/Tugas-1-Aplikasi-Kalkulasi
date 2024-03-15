package com.example.tugas1aplikasikalkulasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class UnitActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnConvert : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var tvMm : TextView
    lateinit var tvDm : TextView
    lateinit var tvM : TextView
    lateinit var tvDam : TextView
    lateinit var tvHm : TextView
    lateinit var tvKm : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnConvert = findViewById(R.id.buttonUnitConvert)
        btnkosong = findViewById(R.id.button_unit_reset)
        etA = findViewById(R.id.et_unit_a)
        tvMm = findViewById(R.id.textUnitMm)
        tvDm = findViewById(R.id.textUnitDm)
        tvM = findViewById(R.id.textUnitM)
        tvDam = findViewById(R.id.textUnitDam)
        tvHm = findViewById(R.id.textUnitHm)
        tvKm = findViewById(R.id.textUnitKm)
        btnConvert.setOnClickListener(this)
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
            R.id.buttonUnitConvert -> {
                convertNumber()
            }
            R.id.button_unit_reset -> {
                resetInput()
            }
        }
    }

    private fun resetInput() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            etA.text.clear()
            tvMm.text = "Millimeter : "
            tvM.text = "Meter : "
            tvDm.text = "Decimeter : "
            tvDam.text = "Decameter : "
            tvHm.text = "Hectometer : "
            tvKm.text = "Kilometer : "
        } else {
            showToast(this, "Inputan masih kosong.")
        }
    }

    private fun convertNumber() {
        val input = etA.text.toString()
        if (input.isNotEmpty()) {
            val a = input.toDouble()
            val kmFormatted = "%.2f".format(a / 100000.0)
            val hmFormatted = "%.2f".format(a / 10000.0)
            val damFormatted = "%.2f".format(a / 1000.0)
            val mFormatted = "%.2f".format(a / 100.0)
            val dmFormatted = "%.2f".format(a / 10.0)
            val mmFormatted = "%.2f".format(a * 10.0)

            tvMm.text = "Millimeter : $mmFormatted"
            tvM.text = "Meter : $mFormatted"
            tvDm.text = "Decimeter : $dmFormatted"
            tvDam.text = "Decameter : $damFormatted"
            tvHm.text = "Hectometer : $hmFormatted"
            tvKm.text = "Kilometer : $kmFormatted"
        } else {
            showToast(this, "Inputan tidak boleh kosong.")
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}