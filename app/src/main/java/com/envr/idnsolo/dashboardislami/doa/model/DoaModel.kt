package com.envr.idnsolo.dashboardislami.doa.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaModel(
    var title : String = "",
    var doa : String = "",
    var latin : String = "",
    var translate : String = "",
    var profile : String = "",
) : Parcelable
