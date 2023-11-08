package com.envr.idnsolo.dashboardislami.shalat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityShalatBinding
import com.loopj.android.http.AsyncHttpClient
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ShalatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShalatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initShalatView()
        getPrayTimeData("1411")
    }

    private fun getPrayTimeData(location: String) {
        val calendar = Calendar.getInstance()
        val tanggal = calendar.get(Calendar.DAY_OF_MONTH)
        val bulan = calendar.get(Calendar.MONTH)
        val tahun = calendar.get(Calendar.YEAR)
        val client = AsyncHttpClient()
        val url = "https://api.myquran.com/v1/sholat/jadwal/$location/$tahun/$bulan/$tanggal"
        Log.d("SholatActivity", "getPrayTimeData: $url")
    }

    private fun initShalatView() {
        val waktu = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MM yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(waktu)

        binding.tvDatePray.text = formattedDate
    }


    private fun initGetDataSholat(today: String, city: String) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.format(dateFormat)

        val client = AsyncHttpClient()
        val urlPrimary = "https://api.myquran.com/v1/sholat/jadwal/"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}