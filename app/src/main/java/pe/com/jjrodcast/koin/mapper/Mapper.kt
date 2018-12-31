/*
 * Developed by Jorge Rodriguez on 31/12/18 02:28 AM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 31/12/18 02:28 AM
 */

package pe.com.jjrodcast.koin.mapper

interface Mapper<in F, out T> {

    fun map(from: F): T
    fun mapList(from: List<F>): List<T>

}