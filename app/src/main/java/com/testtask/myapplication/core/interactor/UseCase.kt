package com.testtask.myapplication.core.interactor


import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class UseCase<out Type, in Params> {
    var backgroundContext: CoroutineContext = Dispatchers.IO
    var foregroundContext: CoroutineContext = Dispatchers.Main

    private var parentJob: Job = Job()

    abstract suspend fun run(params: Params):  Type

    operator fun invoke(params: Params, onResult: (Type) -> Unit = {}) {
        unsubscribe()
        parentJob = Job()

        CoroutineScope(foregroundContext + parentJob).launch {
            val result = withContext(backgroundContext) {
                run(params)
            }

            onResult(result)
        }
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}