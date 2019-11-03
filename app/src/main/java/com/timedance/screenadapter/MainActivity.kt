package com.timedance.screenadapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 查看未适配的效果
     */
    fun clickOriginal(view: View) {
        startToOriginal()
    }

    /**
     * 查看用宽高限定符适配的效果
     */
    fun clickEnumScreenSize(view: View) {
        startToEnumScreenSize()
    }

    /**
     * 查看用最小宽度限定符适配的效果
     */
    fun clickEnumSmallestWidth(view: View) {
        startToEnumSmallestWidth()
    }

    /**
     * 在OnMeasure前拦截并修改相关控件属性
     * 注：
     * 1.此Module的示例fork自hongyangAndroid/AndroidAutoLayout（https://github.com/hongyangAndroid/AndroidAutoLayout）
     * 2.此Module修改为所有属性只基于宽度来进行百分比缩放，与AndroidAutoLayout原来设计不同，这是因为现在的手机宽高比各不相同，和几年前的环境不一样
     * 3.此Module只移植了核心代码
     * 4.此Module暂且性的认为所有的页面都是竖屏的，如果含有部分横屏页面，可以在view初始化的时候做横竖判断，重新得到相应的缩放比
     */
    fun clickHookOnMeasure(view: View) {
        startToHookMeasure()
    }

    fun clickHookDimension(view: View) {
        startToHookDimension()
    }
}
