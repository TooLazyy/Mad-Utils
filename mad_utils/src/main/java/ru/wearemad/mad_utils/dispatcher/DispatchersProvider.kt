package ru.wearemad.mad_utils.dispatcher

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.android.asCoroutineDispatcher

interface DispatchersProvider {

    fun main(): CoroutineDispatcher

    fun mainImmediate(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher
}

class DefaultDispatchersProvider : DispatchersProvider {

    override fun main(): CoroutineDispatcher = Handler(Looper.getMainLooper()).asCoroutineDispatcher()//TODO Dispatchers.Main

    override fun mainImmediate(): CoroutineDispatcher = Handler(Looper.getMainLooper()).asCoroutineDispatcher()//Dispatchers.Main.immediate

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun default(): CoroutineDispatcher = Dispatchers.Default
}