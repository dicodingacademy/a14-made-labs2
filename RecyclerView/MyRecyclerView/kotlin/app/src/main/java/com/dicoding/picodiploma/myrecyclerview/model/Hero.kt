package com.dicoding.picodiploma.myrecyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by sidiqpermana on 10/29/16.
 */

@Parcelize
data class Hero(
    var name: String? = null,
    var description: String? = null,
    var photo: String? = null
) : Parcelable
