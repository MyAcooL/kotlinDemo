package com.cxy.kotlindemo.interfaceCallBack

import java.lang.Exception

interface Result {

    class Success(val msg:String):Result
    class Failure(val error:Exception):Result


}