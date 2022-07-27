package com.testtask.myapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val isAcceptedTerms: Boolean,
    val lastLink: String? = null
): Parcelable {


    companion object {
        @JvmStatic val DEFAULT_TERMS = false
    }
}
