package com.envr.idnsolo.dashboardislami.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityKajianBinding
import com.envr.idnsolo.dashboardislami.kajian.Data.KajianData
import com.envr.idnsolo.dashboardislami.kajian.Model.KajianModel
import com.envr.idnsolo.dashboardislami.kajian.adapter.KajianAdapter

class KajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        kajianRecycler()
    }

    private fun kajianRecycler() {
        binding.rvKajian.layoutManager = LinearLayoutManager(this)
        binding.rvKajian.setHasFixedSize(true)
        val listKajian = ArrayList<KajianModel>()
        listKajian.addAll(KajianData.listData)
        binding.rvKajian.adapter = KajianAdapter(listKajian)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}