package com.cxy.kotlindemo

import android.util.Log

class Util{
//    非伴生对象 需实例后调用
    fun doAction(){
        Log.d("wangwu","doAction")
    }


//    伴生对象 相当于static方法 可全局调用
    companion object{
//    加注解变成真正的静态方法 JvmStatic只能加在单例类或companion object 中的方法上
        @JvmStatic
        fun doAction2(){
            Log.d("wangwu","doAction2")
        }
    }
}