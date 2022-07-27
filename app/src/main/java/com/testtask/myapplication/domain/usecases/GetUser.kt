package com.testtask.myapplication.domain.usecases

import com.testtask.myapplication.core.interactor.UseCase
import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.domain.repository.CoreRepository

class GetUser(private val repository: CoreRepository): UseCase<User?, None>() {

    override suspend fun run(params: None): User? = repository.getUserInfo()
}