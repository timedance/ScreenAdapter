package com.timedance.hookmeasure.autolayout.attr

import android.view.View

import java.lang.reflect.Method

/**
 * Created by zhy on 15/12/24.
 */
internal class MaxHeightAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        try {
            val setMaxWidthMethod = view.javaClass.getMethod("setMaxHeight", Int::class.javaPrimitiveType)
            setMaxWidthMethod.invoke(view, value)
        } catch (ignore: Exception) {
        }
    }

    companion object {
        fun getMaxHeight(view: View): Int {
            try {
                val setMaxWidthMethod = view.javaClass.getMethod("getMaxHeight")
                return setMaxWidthMethod.invoke(view) as Int
            } catch (ignore: Exception) {
            }
            return 0
        }
    }
}
