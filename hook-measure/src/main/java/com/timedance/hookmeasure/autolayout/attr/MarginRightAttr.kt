package com.timedance.hookmeasure.autolayout.attr

import android.view.View
import android.view.ViewGroup

/**
 * Created by zhy on 15/12/5.
 */
internal class MarginRightAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        view.layoutParams?.run {
            this as? ViewGroup.MarginLayoutParams
        }?.apply {
            rightMargin = value
        }
    }
}
