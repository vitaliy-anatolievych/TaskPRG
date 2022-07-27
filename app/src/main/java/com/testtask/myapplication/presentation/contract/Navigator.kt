package com.testtask.myapplication.presentation.contract

import androidx.fragment.app.Fragment


fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun goToWebFragment(url: String?)

    fun exitFromApp()
}