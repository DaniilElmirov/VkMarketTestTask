package com.elmirov.vkmarkettesttask.util

import com.elmirov.vkmarkettesttask.domain.entity.ErrorType
import com.elmirov.vkmarkettesttask.domain.entity.Result
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend fun <D> getResultWithHandleError(
    dispatcher: CoroutineDispatcher,
    data: suspend () -> D
): Result<D> =
    try {
        withContext(dispatcher) {
            Result.Success(data())
        }
    } catch (cancellation: CancellationException) {
        throw cancellation
    } catch (exception: Exception) {
        Result.Error(errorType = ErrorType.UNKNOWN)
    }