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
import kotlin.math.PI

class NumberActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnCheck : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var tvHasil : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnCheck = findViewById(R.id.buttonNumberCheck)
        btnkosong = findViewById(R.id.button_number_reset)
        etA = findViewById(R.id.et_number_a)
        tvHasil = findViewById(R.id.textNumberHasil)
        btnCheck.setOnClickListener(this)
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
            R.id.buttonNumberCheck -> {
                checkNumber()
            }
            R.id.button_number_reset -> {
                resetInput()
            }
        }
    }

    private fun resetInput() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            etA.text.clear()
            tvHasil.text = "Jenis Bilangan :"
        } else {
            showToast(this, "Inputan tidak boleh kosong.")
        }
    }


    private fun checkNumber() {
        val input = etA.text.toString()
        if (input.isNotEmpty()) {
            val a = input.toDouble()
            val hasil = a % 2
            if (hasil.toInt() == 0) {
                tvHasil.text = "Hasil : Genap"
            } else {
                tvHasil.text = "Hasil : Ganjil"
            }
        } else {
            showToast(this, "Inputan tidak boleh kosong.")
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}