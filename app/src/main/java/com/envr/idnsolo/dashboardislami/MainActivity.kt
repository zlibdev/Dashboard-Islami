package com.envr.idnsolo.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.envr.idnsolo.dashboardislami.databinding.ActivityMainBinding
import com.envr.idnsolo.dashboardislami.doa.DoaActivity
import com.envr.idnsolo.dashboardislami.inspiration.InspirationData
import com.envr.idnsolo.dashboardislami.inspiration.InspirationListAdapter
import com.envr.idnsolo.dashboardislami.inspiration.InspirationModel
import com.envr.idnsolo.dashboardislami.kajian.KajianActivity
import com.envr.idnsolo.dashboardislami.shalat.ShalatActivity
import com.envr.idnsolo.dashboardislami.zakat.ZakatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()
        moveActivity()
        initTimeForSholat()

    }

    private fun initTimeForSholat() {
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when{
            time.toInt() in 0 .. 5 -> binding.imgHeader.setImageResource(R.drawable.bg_header_dashboard_night)
            time.toInt() in 6 .. 11 -> binding.imgHeader.setImageResource(R.drawable.bg_header_dashboard_morning)
            time.toInt() in 12 .. 17 -> binding.imgHeader.setImageResource(R.drawable.bg_header_dashboard_afternoon)
            time.toInt() in 18 .. 23 -> binding.imgHeader.setImageResource(R.drawable.bg_header_dashboard_night)        }
    }

    private fun moveActivity() {
        binding.btnDoa.setOnClickListener {
            startActivity(this, DoaActivity::class.java)
        }
        binding.btnZakat.setOnClickListener{
            startActivity(Intent(this, ZakatActivity::class.java))
        }
        binding.btnKajian.setOnClickListener {
            startActivity(Intent(this, KajianActivity::class.java))
        }
        binding.btnJadwalsholat.setOnClickListener {
            startActivity(Intent(this, ShalatActivity::class.java))
        }
    }

    private fun startActivity(mainActivity: MainActivity, java: Class<DoaActivity>) {

    }

    private fun initRecyclerViewInspiration() {
        val listInspiration = ArrayList<InspirationModel>()
        listInspiration.addAll(InspirationData.listData)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationListAdapter(listInspiration)
        binding.rvInspiration.adapter = inspirationAdapter
    }
}