package com.envr.idnsolo.dashboardislami.inspiration

import com.envr.idnsolo.dashboardislami.R

object InspirationData {

    private val InspirationImages = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,

    )

    val listData : ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in InspirationImages.indices){
                val inspiration = InspirationModel()
                inspiration.inspirationImage = InspirationImages[position]
                list.add(inspiration)
            }
            return list
        }
}
