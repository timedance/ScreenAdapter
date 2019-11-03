package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingLeftAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val t = view.paddingTop
        val r = view.paddingRight
        val b = view.paddingBottom
        view.setPadding(value, t, r, b)

    }

}
