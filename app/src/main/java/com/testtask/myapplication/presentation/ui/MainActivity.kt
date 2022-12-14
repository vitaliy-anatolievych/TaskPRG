package com.testtask.myapplication.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.testtask.myapplication.R
import com.testtask.myapplication.databinding.ActivityMainBinding
import com.testtask.myapplication.presentation.contract.Navigator
import com.testtask.myapplication.presentation.contract.webNavigator
import com.testtask.myapplication.presentation.ui.fragments.StartFragment
import com.testtask.myapplication.presentation.ui.fragments.WebViewFragment
import com.testtask.myapplication.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    val viewModel: AppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            viewModel.getUser()
        }

        launchApp()
    }

    private fun launchApp() {
        viewModel.userData.observe(this) { user ->
            if (user == null) {
                launchFragment(StartFragment(), false)
            } else {
                goToWebFragment(user.lastLink)
            }
        }
    }

    override fun goToWebFragment(url: String?) {
        launchFragment(WebViewFragment.newInstance(url), false)
    }

    override fun exitFromApp() {
        this.finishAndRemoveTask()
    }

    private fun launchFragment(fragment: Fragment, isAddToBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.app_fragment_container, fragment, fragment::class.simpleName)
            if (isAddToBackStack) addToBackStack(fragment::class.simpleName)
            commit()
        }
    }

    override fun onBackPressed() {
        webNavigator().loadPreviousPage()
    }
}