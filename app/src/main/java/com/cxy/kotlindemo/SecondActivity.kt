package com.cxy.kotlindemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

        val list= listOf("1","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2")
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        listview.adapter=adapter
        listview.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(this,list.get(position),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button2 -> Toast.makeText(this,"点击了按钮2",Toast.LENGTH_SHORT).show()
            R.id.button3 -> {
                AlertDialog.Builder(this).apply {
                    setTitle("这是一个没有什么意义的弹框")
                    setMessage("这是一条没有什么意义的消息")
                    setCancelable(false)
                    setPositiveButton("确定"){dialog,which->Toast.makeText(this@SecondActivity as Context,"点击了确定",Toast.LENGTH_SHORT).show()}
                    setNegativeButton("取消"){dialog,which ->Toast.makeText(this@SecondActivity as Context,"点击了取消",Toast.LENGTH_SHORT).show()}
                    show()
                }
            }
        }
    }
}
