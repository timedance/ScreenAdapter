package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingRightAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val l = view.paddingLeft
        val t = view.paddingTop
        val b = view.paddingBottom
        view.setPadding(l, t, value, b)

    }

}
