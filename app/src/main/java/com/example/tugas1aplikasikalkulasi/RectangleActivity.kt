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
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.round

class RectangleActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnWide : CardView
    lateinit var btnAround : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var tvHasil : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnWide = findViewById(R.id.buttonRectangleWide)
        btnAround = findViewById(R.id.buttonRectangleAround)
        btnkosong = findViewById(R.id.button_rectangle_reset)
        etA = findViewById(R.id.et_rectangle_a)
        etB = findViewById(R.id.et_rectangle_b)
        tvHasil = findViewById(R.id.textRectangleHasil)
        btnWide.setOnClickListener(this)
        btnAround.setOnClickListener(this)
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
            R.id.buttonRectangleWide -> {
                hitungLuasPersegiPanjang()
            }
            R.id.buttonRectangleAround -> {
                hitungKelilingPersegiPanjang()
            }
            R.id.button_rectangle_reset -> {
                resetInput()
            }
        }
    }

    private fun hitungLuasPersegiPanjang() {
        val a = etA.text.toString()
        val b = etB.text.toString()
        if (a.isNotEmpty() || b.isNotEmpty()) {
            val a = a.toDouble()
            val b = b.toDouble()
            val hasil = a*b
            tvHasil.text = "Hasil : ${formatAngka(hasil)}"
        } else {
            showToast(this, "Periksa kembali inputan anda.")
        }
    }

    private fun hitungKelilingPersegiPanjang() {
        val a = etA.text.toString()
        val b = etB.text.toString()
        if (a.isNotEmpty() && b.isNotEmpty()) {
            val a = a.toDouble()
            val b = b.toDouble()
            val hasil = 2*(a+b)
            tvHasil.text = "Hasil : ${formatAngka(hasil)}"
        } else {
            showToast(this, "Periksa kembali inputan anda.")
        }
    }

    private fun resetInput() {
        val a = etA.text.toString()
        val b = etB.text.toString()
        if (a.isNotEmpty() || b.isNotEmpty()) {
            etA.text.clear()
            etB.text.clear()
            tvHasil.text = "Hasil :"
        }else{
            etA.text.clear()
            etB.text.clear()
            showToast(this, "Periksa kembali inputan anda.")

        }

    }

    private fun formatAngka(angka: Double): String {
        val df = DecimalFormat("#.##")
        return df.format(angka)
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}