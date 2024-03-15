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

class CircularActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnWide : CardView
    lateinit var btnAround : CardView
    lateinit var btnkosong : ImageButton
    lateinit var etA : EditText
    lateinit var tvHasil : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnWide = findViewById(R.id.buttonCircularWide)
        btnAround = findViewById(R.id.buttonCircularAround)
        btnkosong = findViewById(R.id.button_circular_reset)
        etA = findViewById(R.id.et_circle_a)
        tvHasil = findViewById(R.id.textCircleHasil)
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
            R.id.buttonCircularWide -> {
                hitungLuasLingkaran()
            }
            R.id.buttonCircularAround -> {
                hitungKelilingLingkaran()
            }
            R.id.button_circular_reset -> {
                resetInput()
            }
        }
    }

    private fun hitungLuasLingkaran() {
        val input = etA.text.toString()
        if (input.isNotEmpty()) {
            val a = input.toDouble()
            val hasil = PI * a * a
            tvHasil.text = "Hasil : ${formatAngka(hasil)}"
        } else {
            showToast(this, "Periksa kembali inputan anda.")
        }
    }

    private fun hitungKelilingLingkaran() {
        val input = etA.text.toString()
        if (input.isNotEmpty()) {
            val a = input.toDouble()
            val hasil = PI * 2 * a
            tvHasil.text = "Hasil : ${formatAngka(hasil)}"
        } else {
            showToast(this, "Periksa kembali inputan anda.")
        }
    }

    private fun resetInput() {
        val a = etA.text.toString()
        if (a.isNotEmpty()) {
            etA.text.clear()
            tvHasil.text = "Hasil :"
        }else{
            etA.text.clear()
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