package ru.wearemad.mad_utils.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import ru.wearemad.mad_utils.request_result.RequestResult

@Suppress("UNCHECKED_CAST")
suspend fun <T1 : Any, T2 : Any, R : Any> combineResults(
    t1: RequestResult<T1>,
    t2: RequestResult<T2>,
    combiner: (T1, T2) -> R
): RequestResult<R> = coroutineScope {
    val result = awaitAll(
        async { t1 },
        async { t2 }
    )
    val failed = result.firstOrNull { it is RequestResult.Error } as? RequestResult.Error
    if (failed == null) {
        RequestResult.Success(
            combiner(
                (result[0] as RequestResult.Success<T1>).data,
                (result[1] as RequestResult.Success<T2>).data,
            )
        )
    } else {
        RequestResult.Error(failed.error)
    }
}

@Suppress("UNCHECKED_CAST")
suspend fun <T1 : Any, T2 : Any, T3 : Any, R : Any> combineResults(
    t1: RequestResult<T1>,
    t2: RequestResult<T2>,
    t3: RequestResult<T3>,
    combiner: (T1, T2, T3) -> R
): RequestResult<R> = coroutineScope {
    val result = awaitAll(
        async { t1 },
        async { t2 },
        async { t3 },
    )
    val failed = result.firstOrNull { it is RequestResult.Error } as? RequestResult.Error
    if (failed == null) {
        RequestResult.Success(
            combiner(
                (result[0] as RequestResult.Success<T1>).data,
                (result[1] as RequestResult.Success<T2>).data,
                (result[2] as RequestResult.Success<T3>).data,
            )
        )
    } else {
        RequestResult.Error(failed.error)
    }
}

@Suppress("UNCHECKED_CAST")
suspend fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, R : Any> combineResults(
    t1: RequestResult<T1>,
    t2: RequestResult<T2>,
    t3: RequestResult<T3>,
    t4: RequestResult<T4>,
    combiner: (T1, T2, T3, T4) -> R
): RequestResult<R> = coroutineScope {
    val result = awaitAll(
        async { t1 },
        async { t2 },
        async { t3 },
        async { t4 },
    )
    val failed = result.firstOrNull { it is RequestResult.Error } as? RequestResult.Error
    if (failed == null) {
        RequestResult.Success(
            combiner(
                (result[0] as RequestResult.Success<T1>).data,
                (result[1] as RequestResult.Success<T2>).data,
                (result[2] as RequestResult.Success<T3>).data,
                (result[3] as RequestResult.Success<T4>).data,
            )
        )
    } else {
        RequestResult.Error(failed.error)
    }
}

@Suppress("UNCHECKED_CAST")
suspend fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, R : Any> combineResults(
    t1: RequestResult<T1>,
    t2: RequestResult<T2>,
    t3: RequestResult<T3>,
    t4: RequestResult<T4>,
    t5: RequestResult<T5>,
    combiner: (T1, T2, T3, T4, T5) -> R
): RequestResult<R> = coroutineScope {
    val result = awaitAll(
        async { t1 },
        async { t2 },
        async { t3 },
        async { t4 },
        async { t5 },
    )
    val failed = result.firstOrNull { it is RequestResult.Error } as? RequestResult.Error
    if (failed == null) {
        RequestResult.Success(
            combiner(
                (result[0] as RequestResult.Success<T1>).data,
                (result[1] as RequestResult.Success<T2>).data,
                (result[2] as RequestResult.Success<T3>).data,
                (result[3] as RequestResult.Success<T4>).data,
                (result[4] as RequestResult.Success<T5>).data,
            )
        )
    } else {
        RequestResult.Error(failed.error)
    }
}