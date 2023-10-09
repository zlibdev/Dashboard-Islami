package com.envr.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityDetailDoaBinding
import com.envr.idnsolo.dashboardislami.databinding.ActivityDetailListDoaBinding

class DetailListDoaActivity : AppCompatActivity() {


    private lateinit var binding : ActivityDetailListDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}