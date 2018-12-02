package pe.com.jjrodcast.koin.view

import android.content.Context

interface BaseView {

    fun getContent(): Context

    fun init()
}