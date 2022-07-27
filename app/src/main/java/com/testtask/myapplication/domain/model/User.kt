package com.testtask.myapplication.domain.model

data class User(
    val isAcceptedTerms: Boolean,
    val lastLink: String? = null
) {


    companion object {
        @JvmStatic val DEFAULT_TERMS = false
    }
}
