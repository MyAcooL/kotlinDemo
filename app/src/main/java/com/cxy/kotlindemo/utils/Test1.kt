package com.cxy.kotlindemo.utils

import android.util.Log

object Test1 {
    fun Split(url:String) {
        val split = url.split("/").toTypedArray()
        val builder = StringBuilder()
        builder.append("/")
        for (i in split.indices) {
            if (i > 2) {
                builder.append(split[i]).append("/")
            }
        }
        val toString = builder.substring(0, builder.length - 1).toString()
        Log.d("wangwu", "builder: $toString")
    }
}