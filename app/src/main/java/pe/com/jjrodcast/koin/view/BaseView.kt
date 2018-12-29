/*
 * Developed by Jorge Rodriguez on 29/12/18 01:05 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 30/11/18 11:09 AM
 */

package pe.com.jjrodcast.koin.view

import android.content.Context

interface BaseView {

    fun getContent(): Context

    fun init()
}