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

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btntambah : CardView
    lateinit var btnkurang : CardView
    lateinit var btnkali : CardView
    lateinit var btnbagi : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var tvHasil : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btntambah = findViewById(R.id.buttonPlus)
        btnkurang = findViewById(R.id.buttonMinus)
        btnkali = findViewById(R.id.buttonMultiplication)
        btnbagi = findViewById(R.id.buttonDistribution)
        btnkosong = findViewById(R.id.button_calculator_reset)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        tvHasil = findViewById(R.id.textHasil)
        btntambah.setOnClickListener(this)
        btnkurang.setOnClickListener(this)
        btnkali.setOnClickListener(this)
        btnbagi.setOnClickListener(this)
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
        val a = etA.text.toString()
        val b = etB.text.toString()
        if (a.isNotEmpty() || b.isNotEmpty()) {
            val a = a.toDouble()
            val b = b.toDouble()
            var hasil=0.0
            when(v?.id){
                R.id.buttonPlus ->{
                    hasil = a+b
                }
                R.id.buttonMinus ->{
                    hasil = a-b
                }
                R.id.buttonMultiplication ->{
                    hasil = a*b
                }
                R.id.buttonDistribution ->{
                    hasil = a/b
                }
                R.id.button_calculator_reset ->{
                    etA.text.clear()
                    etB.text.clear()
                    hasil=0.0
                    etA.requestFocus()
                }
            }
            tvHasil.text = "Hasil : $hasil"
        } else {
            showToast(this, "Periksa kembali inputan anda.")
        }

    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}