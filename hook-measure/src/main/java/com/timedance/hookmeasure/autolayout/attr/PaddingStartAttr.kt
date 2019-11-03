package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingStartAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val t = view.paddingTop
        val e = view.paddingEnd
        val b = view.paddingBottom
        view.setPaddingRelative(value, t, e, b)
    }

}
