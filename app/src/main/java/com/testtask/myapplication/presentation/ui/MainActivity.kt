package com.testtask.myapplication.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.testtask.myapplication.R
import com.testtask.myapplication.databinding.ActivityMainBinding
import com.testtask.myapplication.presentation.contract.Navigator
import com.testtask.myapplication.presentation.ui.fragments.StartFragment
import com.testtask.myapplication.presentation.ui.fragments.WebViewFragment

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            launchFragment(StartFragment(), false)
        }
    }

    override fun goToWebFragment() {
        launchFragment(WebViewFragment(), false)
    }

    override fun exitFromApp() {
        this.finishAndRemoveTask()
    }

    private fun launchFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.app_fragment_container, fragment)
            if (isAddToBackStack) addToBackStack(fragment::class.simpleName)
            commit()
        }
    }
}