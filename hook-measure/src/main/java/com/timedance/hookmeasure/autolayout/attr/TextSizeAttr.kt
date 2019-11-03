package com.timedance.hookmeasure.autolayout.attr

import android.util.TypedValue
import android.view.View
import android.widget.TextView

/**
 * Created by zhy on 15/12/4.
 */
internal class TextSizeAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        if (view !is TextView) return
        view.includeFontPadding = false
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, value.toFloat())
    }

}
