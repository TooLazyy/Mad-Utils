package ru.wearemad.mad_utils.request_result

sealed class RequestResult<out T : Any?> {

    companion object {

        fun <T : Any?> success(data: T): RequestResult<T> = Success(data)

        fun error(error: Throwable): RequestResult<Nothing> = Error(error)
    }

    data class Success<T : Any?>(val data: T) : RequestResult<T>()

    data class Error(val error: Throwable) : RequestResult<Nothing>()
}