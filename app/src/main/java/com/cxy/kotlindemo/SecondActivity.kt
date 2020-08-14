package com.cxy.kotlindemo

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.cxy.kotlindemo.adapter.FriuterAdapter
import com.cxy.kotlindemo.bean.Friut
import com.cxy.kotlindemo.utils.SimpleDividerItemDecoration
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(),View.OnClickListener {


    private val fruitList= ArrayList<Friut>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

//        val list= listOf("1","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2")
//        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
//        listview.adapter=adapter
//        listview.setOnItemClickListener { adapterView, view, position, l ->
//            Toast.makeText(this,list.get(position),Toast.LENGTH_SHORT).show()
//        }
        initFruits()
        val layoutManager=GridLayoutManager(this,3)
        recyclerview.layoutManager=layoutManager
        recyclerview.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(outRect: Rect,view: View,parent: RecyclerView,state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = 10
                outRect.left = 5
//                outRect.top = 10
                outRect.right = 5
            }
        })
        val adapter=FriuterAdapter(fruitList)
        recyclerview.adapter=adapter

    }

    private fun initFruits() {

        repeat(2){
            fruitList.add(Friut("qqweqwe",R.mipmap.ic_launcher))
            fruitList.add(Friut("qqweqwe",R.mipmap.ic_launcher))
            fruitList.add(Friut("qqweqwe",R.mipmap.ic_launcher))
            fruitList.add(Friut("qqweqwe",R.mipmap.ic_launcher))
            fruitList.add(Friut("qqweqwe",R.mipmap.ic_launcher))
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
