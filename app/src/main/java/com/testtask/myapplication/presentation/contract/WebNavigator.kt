package com.testtask.myapplication.presentation.contract

import androidx.appcompat.app.AppCompatActivity
import com.testtask.myapplication.presentation.ui.fragments.WebViewFragment

fun AppCompatActivity.webNavigator(): WebNavigator {
    return supportFragmentManager.findFragmentByTag(WebViewFragment::class.simpleName) as WebNavigator
}

interface WebNavigator {

    fun loadPreviousPage()
}