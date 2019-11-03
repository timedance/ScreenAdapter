package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingEndAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val s = view.paddingStart
        val t = view.paddingTop
        val b = view.paddingBottom
        view.setPaddingRelative(s, t, value, b)
    }

}
