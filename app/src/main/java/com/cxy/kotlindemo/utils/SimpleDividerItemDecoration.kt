package com.cxy.kotlindemo.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.cxy.kotlindemo.R

class SimpleDividerItemDecoration : ItemDecoration {
    private var mDivider //分割线Drawable
            : Drawable? = null
    private var mDividerHeight //分割线高度
            : Int
    private var inset :Int = 0//分割线缩进值 = 0

    /**
     * 使用line_divider中定义好的颜色
     *
     * @param context
     * @param dividerHeight 分割线高度
     */
    constructor(context: Context?, dividerHeight: Int) {
        mDivider = ContextCompat.getDrawable(context!!, R.drawable.line_divider)
        mDividerHeight = dividerHeight
    }

    constructor(context: Context?, inset: Int, dividerHeight: Int) {
        this.inset = inset
        mDivider = ContextCompat.getDrawable(context!!, R.drawable.line_divider)
        mDividerHeight = dividerHeight
    }

    /**
     * @param context
     * @param divider       分割线Drawable
     * @param dividerHeight 分割线高度
     */
    constructor(context: Context?, divider: Drawable?, dividerHeight: Int) {
        mDivider = divider ?: ContextCompat.getDrawable(context!!, R.drawable.line_divider)
        mDividerHeight = dividerHeight
    }

    //获取分割线尺寸
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect[0, 0, 0] = mDividerHeight
//        outRect.bottom=mDividerHeight
//        outRect.top=mDividerHeight
//        outRect.left=mDividerHeight
//        outRect.right=mDividerHeight
    }

    override fun onDrawOver(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        //最后一个item不画分割线
        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params =
                child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            //            int bottom = top + mDividerHeight;
            val bottom = top + mDivider!!.intrinsicHeight
            if (inset > 0) {
                mDivider!!.setBounds(left + inset, top, right - inset, bottom)
            } else {
                mDivider!!.setBounds(left, top, right, bottom)
            }
            mDivider!!.draw(c)
        }
    }
}