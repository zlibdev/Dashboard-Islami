package com.envr.idnsolo.dashboardislami.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityDoaBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Doa Harian"
        actionBar.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()
    }

    private fun intentToListActivity() {
        binding.cardDoaPagiMalam.setOnClickListener{
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.cardDoaRumah.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.rumah))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.cardMakananMinuman.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.makanan_dan_minuman))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        binding.cardSholat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.sholat))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        binding.cardEtikaBaik.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.etika_baik))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
        binding.cardDoaPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.perjalanan))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}