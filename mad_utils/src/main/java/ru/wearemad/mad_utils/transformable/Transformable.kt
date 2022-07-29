package ru.wearemad.mad_utils.transformable

interface Transformable<T : Any?> {

    fun transform(): T
}