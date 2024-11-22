package com.example.kotlinsubmission.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val judul: String,
    val desc: String,
    var photos: Int,
    val isi: String,
    val kategori: String
) : Parcelable
