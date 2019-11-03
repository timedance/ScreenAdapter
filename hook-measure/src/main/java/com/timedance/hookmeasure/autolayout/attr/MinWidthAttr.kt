package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/24.
 */
internal class MinWidthAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        view.minimumWidth = value
    }

    companion object {

        fun getMinWidth(view: View): Int {
            return view.minimumWidth
        }
    }

}
