package com.testtask.myapplication.domain.usecases

import com.testtask.myapplication.core.interactor.UseCase
import com.testtask.myapplication.core.type.None
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.domain.repository.CoreRepository

class SaveUser(private val repository: CoreRepository): UseCase<None, SaveUser.Params>() {

    data class Params(val user: User)

    override suspend fun run(params: Params): None = repository.saveUser(params.user)
}