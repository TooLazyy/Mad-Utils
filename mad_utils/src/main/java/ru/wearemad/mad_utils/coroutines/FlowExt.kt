package ru.wearemad.mad_utils.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import ru.wearemad.mad_utils.request_result.RequestResult

suspend fun <T : Any?, R : Any?> Flow<RequestResult<T>>.mapFlow(mapper: suspend (T) -> R): Flow<RequestResult<R>> {
    return map {
        when (it) {
            is RequestResult.Error -> RequestResult.Error(it.error)
            is RequestResult.Success -> RequestResult.Success(mapper(it.data))
        }
    }
}

suspend fun <T : Any?, R : Any?> Flow<RequestResult<T>>.mapFlowResult(mapper: suspend (T) -> RequestResult<R>): Flow<RequestResult<R>> {
    return map {
        when (it) {
            is RequestResult.Error -> RequestResult.Error(it.error)
            is RequestResult.Success -> mapper(it.data)
        }
    }
}

suspend fun <T : Any> Flow<RequestResult<T>>.wrapError(): Flow<RequestResult<T>> = catch {
    emit(RequestResult.Error(it))
}