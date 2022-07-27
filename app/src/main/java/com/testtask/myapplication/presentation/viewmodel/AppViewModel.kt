package com.testtask.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.domain.usecases.GetUser
import com.testtask.myapplication.domain.usecases.SaveUser

class AppViewModel(
    private val saveUserUseCase: SaveUser,
    private val getUserUseCase: GetUser
) : ViewModel() {

    private val _userData = MutableLiveData<User?>()
    val userData: LiveData<User?>
        get() = _userData

    fun saveUser(user: User) {
        saveUserUseCase(SaveUser.Params(user))
    }

    fun getUser() {
        getUserUseCase(None()) {
            _userData.value = it
        }
    }

    override fun onCleared() {
        super.onCleared()
        saveUserUseCase.unsubscribe()
        getUserUseCase.unsubscribe()
    }
}