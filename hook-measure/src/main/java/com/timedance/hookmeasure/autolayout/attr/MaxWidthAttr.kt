package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/24.
 */
internal class MaxWidthAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        try {
            val setMaxWidthMethod = view.javaClass.getMethod("setMaxWidth", Int::class.javaPrimitiveType)
            setMaxWidthMethod.invoke(view, value)
        } catch (ignore: Exception) {
        }

    }

    companion object {

        fun getMaxWidth(view: View): Int {
            try {
                val setMaxWidthMethod = view.javaClass.getMethod("getMaxWidth")
                return setMaxWidthMethod.invoke(view) as Int
            } catch (ignore: Exception) {
            }

            return 0
        }
    }
}
