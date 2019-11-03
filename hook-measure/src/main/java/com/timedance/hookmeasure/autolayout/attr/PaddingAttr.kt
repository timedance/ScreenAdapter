package com.timedance.hookmeasure.autolayout.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
internal class PaddingAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        view.setPadding(value, value, value, value)
    }

}
