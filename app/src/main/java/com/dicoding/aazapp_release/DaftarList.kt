package com.dicoding.aazapp_release

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Membuat Data Class dengan plugin Parcelize
@Parcelize
data class DaftarList(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
