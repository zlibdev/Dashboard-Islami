package com.envr.idnsolo.dashboardislami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.envr.idnsolo.dashboardislami.databinding.ActivityMainBinding
import com.envr.idnsolo.dashboardislami.doa.DoaActivity
import com.envr.idnsolo.dashboardislami.inspiration.InspirationData
import com.envr.idnsolo.dashboardislami.inspiration.InspirationListAdapter
import com.envr.idnsolo.dashboardislami.inspiration.inspirationModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerViewInspiration()
        showMenu()

    }

    private fun showMenu() {
        binding.btnDoa.setOnClickListener {
            startActivity(this, DoaActivity::class.java)
        }
    }

    private fun startActivity(mainActivity: MainActivity, java: Class<DoaActivity>) {

    }

    private fun initRecyclerViewInspiration() {
        val list : ArrayList<inspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.add(InspirationData.listdata)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationListAdapter(list)
        binding.rvInspiration.adapter = inspirationAdapter

    }
}