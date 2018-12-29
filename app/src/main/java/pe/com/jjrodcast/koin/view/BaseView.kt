/*
 * Developed by Jorge Rodriguez on 29/12/18 01:10 PM
 * Copyright (c) 2018 . All rights reserved.
 * Last modified 29/12/18 01:09 PM
 */

package pe.com.jjrodcast.koin.view

import android.content.Context

interface BaseView {

    fun getContent(): Context

    fun init()
}