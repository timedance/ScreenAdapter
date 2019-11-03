package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/24.
 */
internal class MinHeightAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        view.minimumHeight = value
    }

    companion object {
        fun getMinHeight(view: View): Int {
            return view.minimumHeight
        }
    }

}
