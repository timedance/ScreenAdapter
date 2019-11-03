package com.timedance.hookmeasure.autolayout.attr

import android.view.View
import com.timedance.hookmeasure.autolayout.utils.AutoUtils


/**
 * Created by zhy on 15/12/4.
 */
internal abstract class AutoAttr(protected var pxVal: Int) {
    private val percentWidthSize = AutoUtils.getPercentWidthSize(pxVal)

    open fun apply(view: View) {
        if (pxVal == 0) { //如果没有值，则不需要缩放
            return
        }
        execute(view, percentWidthSize)
    }

    protected abstract fun execute(view: View, value: Int)

}
