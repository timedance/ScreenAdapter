package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingBottomAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val l = view.paddingLeft
        val t = view.paddingTop
        val r = view.paddingRight
        view.setPadding(l, t, r, value)

    }

}
