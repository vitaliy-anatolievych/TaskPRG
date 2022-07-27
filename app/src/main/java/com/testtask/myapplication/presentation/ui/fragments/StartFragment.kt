package com.testtask.myapplication.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.testtask.myapplication.databinding.FragmentStartBinding
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.presentation.contract.navigator
import com.testtask.myapplication.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartFragment: Fragment() {

    private val viewModel: AppViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentStartBinding.inflate(inflater, container, false).apply {
        btnAcceptTerms.setOnClickListener { onAcceptTerms() }
        btnDeclineTerms.setOnClickListener { onDeclineTerms() }
    }.root

    private fun onAcceptTerms() {
        viewModel.saveUser(User(isAcceptedTerms = true))
        navigator().goToWebFragment(null)
    }

    private fun onDeclineTerms() {
        navigator().exitFromApp()
    }
}