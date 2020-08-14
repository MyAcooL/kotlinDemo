package com.cxy.kotlindemo

import android.util.Log

// 定义的顶层方法 需创建一个file类型的文件  kotlin 会将所有的顶层方法编译成静态方法 可以全局调用
fun doSomething(){
    Log.d("wangwu","doSomething")
}