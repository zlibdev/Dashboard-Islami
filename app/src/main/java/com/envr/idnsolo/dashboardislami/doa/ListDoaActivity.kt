package com.envr.idnsolo.dashboardislami.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.envr.idnsolo.dashboardislami.R
import com.envr.idnsolo.dashboardislami.databinding.ActivityDetailListDoaBinding
import com.envr.idnsolo.dashboardislami.doa.adapter.DoaListAdapter
import com.envr.idnsolo.dashboardislami.doa.data.DoaEtikaBaik
import com.envr.idnsolo.dashboardislami.doa.data.DoaMakananMinuman
import com.envr.idnsolo.dashboardislami.doa.data.DoaPagiMalam
import com.envr.idnsolo.dashboardislami.doa.data.DoaPerjalanan
import com.envr.idnsolo.dashboardislami.doa.data.DoaRumah
import com.envr.idnsolo.dashboardislami.doa.data.DoaSholat
import com.envr.idnsolo.dashboardislami.doa.model.DoaModel

class ListDoaActivity : AppCompatActivity() {


    private lateinit var binding : ActivityDetailListDoaBinding
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE, 0)

        val actionBar = supportActionBar
        actionBar?.title = title
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title){
            getString(R.string.pagi_dan_malam)->{
                list.addAll(DoaPagiMalam.listDoaPagiDanMalam)
            }
            getString(R.string.rumah)-> {
                list.addAll(DoaRumah.listDoaRumah)
            }
            getString(R.string.perjalanan)-> {
                list.addAll(DoaPerjalanan.listDoaPerjalanan)
            }
            getString(R.string.etika_baik)-> {
                list.addAll(DoaEtikaBaik.listDoaEtikaBaik)
            }
            getString(R.string.sholat)-> {
                list.addAll(DoaSholat.listDoaShalat)
            }
            getString(R.string.makanan_dan_minuman)-> {
                list.addAll(DoaMakananMinuman.listDoaMakananDanMinuman)
            }
        }
        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager = LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter
    }

    //back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMAGE = "extra_image"
    }
}