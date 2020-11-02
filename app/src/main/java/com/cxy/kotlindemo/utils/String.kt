package com.cxy.kotlindemo.utils

// 顶层方法实现扩展函数 方便全局调用


// 统计某个字符串中字母的数量
fun String.letterCount():Int{

    var count=0
    for (char in this){
        if (char.isLetter()){
            count++
        }
    }
    return count

}