package com.envr.idnsolo.dashboardislami.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
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

        setSupportActionBar(binding.toolbar)

        initHitungZakat()

    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener{
            var isEmptyField = false
            val localeID = Locale("in", "ID")
            val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
            val totalHarta = binding.edtTotalHartaKeseluruhan.text.trim().toString()

            if (totalHarta.isEmpty()) {
                isEmptyField = true
                binding.edtTotalHartaKeseluruhan.error = "Field ini tidak boleh kosong!"
            }

            if (!isEmptyField){

                if(totalHarta.toInt()!! < 92395000){
                    binding.tvTotalHartaKeseluruhan.text = formatRupiah.format(totalHarta.toInt()!!)
                    binding.tvStatus.text = "Tidak Wajib Zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(0)
                    Toast.makeText(this, "Tidak Wajib Zakat", Toast.LENGTH_SHORT).show()
                } else {
                    binding.tvTotalHartaKeseluruhan.text = formatRupiah.format(totalHarta.toInt()!!)
                    binding.tvStatus.text = "Anda wajib membayar Zakat"
                    binding.tvZakatYangDikeluarkan.text = formatRupiah.format(totalHarta.toInt()!! * 0.025)
                    Toast.makeText(this, "Wajib Zakat", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
        onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}