package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingTopAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val l = view.paddingLeft
        val r = view.paddingRight
        val b = view.paddingBottom
        view.setPadding(l, value, r, b)
    }

}
