package com.timedance.hookmeasure.autolayout.attr

import android.view.View
import android.view.ViewGroup

/**
 * Created by zhy on 15/12/5.
 */
internal class WidthAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        val lp = view.layoutParams
        lp.width = value
    }

}
