package com.envr.idnsolo.dashboardislami.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Zakat"
        actionBar.setDisplayHomeAsUpEnabled(true)

        initHitungZakat()

    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener{
            var isEmptyField = false
            val totalHarta = binding.edtTotalHartaKeseluruhan.text.trim().toString()

            if (totalHarta.isEmpty()) {
                !isEmptyField
                binding.edtTotalHartaKeseluruhan.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyField){

                val emas = 92395000
                val persen = 0.025
                val localeID = Locale("in", "ID")
                val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)

                if(totalHarta < emas.toString()){
                    binding.tvStatus.text = "Anda Belum Wajib Zakat"
                    binding.tvZakatYangDikeluarkan.text = "0"
                } else {
                    val zakat = totalHarta.toInt() * persen
                    binding.tvStatus.text = "Anda wajib membayar Zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(zakat)
                }
            }

        }

    }
}