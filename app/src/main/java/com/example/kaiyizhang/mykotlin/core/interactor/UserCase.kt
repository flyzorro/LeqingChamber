package com.example.kaiyizhang.mykotlin.core.interactor

import com.example.kaiyizhang.mykotlin.core.exception.Failure
import com.example.kaiyizhang.mykotlin.core.functional.Either

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch


abstract class UseCase<out Type, in Params> where Type : Any {
    abstract suspend fun run(params: Params): Either<Failure, Type>

    fun execute(onResult: (Either<Failure, Type>) -> Unit, params: Params) {
        val job = async(CommonPool) { run(params) }
        launch(UI) { onResult.invoke(job.await()) }
    }
}
