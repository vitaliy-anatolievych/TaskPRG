package com.testtask.myapplication.domain.repository

import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User

interface CoreRepository {
    fun getUserInfo(): User?
    fun saveUser(user: User): None
}