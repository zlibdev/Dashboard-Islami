package com.envr.idnsolo.dashboardislami.shalat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityShalatBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ShalatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShalatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initShalatView()
    }

    private fun initShalatView() {
        val date: Date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy")
        val today = dateFormat.format(date)

        binding.tvDatePray.text = today
        
        initGetDataSholat(today, "Jakarta")
    }

    private fun initGetDataSholat(today: String, s: String) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}