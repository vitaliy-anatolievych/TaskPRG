package com.testtask.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.domain.usecases.SaveUser

class AppViewModel(
    private val saveUserUseCase: SaveUser
): ViewModel() {

    fun saveUser(user: User) {
        saveUserUseCase(SaveUser.Params(user))
    }
}