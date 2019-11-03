package com.timedance.hookmeasure.autolayout.attr

import android.view.View
import android.widget.TextView

/**
 * Created by zhy on 15/12/5.
 */
internal class LineSpacingExtraAttr(pxVal: Int) : AutoAttr(pxVal) {

    override fun execute(view: View, value: Int) {
        view.run {
            this as? TextView
        }?.apply {
            setLineSpacing(value.toFloat(), lineSpacingMultiplier)
        }
    }

}
