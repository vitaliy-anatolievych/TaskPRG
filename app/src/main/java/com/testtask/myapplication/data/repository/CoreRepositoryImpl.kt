package com.testtask.myapplication.data.repository

import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.data.local.LocalCache
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.domain.repository.CoreRepository

class CoreRepositoryImpl(
    private var localCache: LocalCache
): CoreRepository {

    override fun getUserInfo(): User? = localCache.getUser()

    override fun saveUser(user: User): None = localCache.saveUser(user)

}