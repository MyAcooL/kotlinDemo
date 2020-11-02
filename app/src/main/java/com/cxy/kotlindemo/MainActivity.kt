package com.cxy.kotlindemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cxy.kotlindemo.utils.Test1
import com.cxy.kotlindemo.utils.letterCount
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t=Test1
        t.Split("http://btjj.wegraphic.com/ApiCertificatePhoto/CertificateUpLoadImgrnd/newApi/userInfo")

        val count="asdaEQ@!#1213".letterCount()
        Log.d("wangwu", "count: $count")


        val p = Person()
        p.age = 26
        p.name = "AcooL"
        button1.text = "测试赋值啊"
        button1.setOnClickListener {
            //            Toast.makeText(this,"测试Toast",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        val list= listOf("Apple","Banna","Orang","Pear","Grape")
//        val builder=StringBuilder()
//        builder.append("开始吃水果：\n")
//        for (friut in list){
//            builder.append(friut).append("\n")
//        }
//        builder.append("吃完所有的水果了")
//        Log.d("wangwu",builder.toString())

        val result= with(StringBuilder()){
            append("开始吃水果：\n")
            for (friut in list){
                append(friut).append("\n")
            }
            append("吃完所有的水果了")
            toString()
        }
//        Log.d("wangwu",result)

//        测试静态方法
        Util.doAction2()
        val util=Util()
        util.doAction()
//        测试顶层方法(相当于静态的全局方法)
        doSomething()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    class Person {
        var name = ""
        var age = 0
        fun print(): String {
            return name + age
        }
    }
}
