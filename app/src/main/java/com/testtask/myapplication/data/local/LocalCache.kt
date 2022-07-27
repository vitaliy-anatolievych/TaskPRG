package com.testtask.myapplication.data.local

import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User

interface LocalCache {
    fun saveUser(user: User): None
}