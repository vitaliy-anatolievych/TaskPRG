package com.testtask.myapplication.domain.repository

import com.testtask.myapplication.domain.model.User

interface CoreRepository {
    fun getUserInfo(): User
}