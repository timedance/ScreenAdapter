package com.timedance.hookmeasure.autolayout

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.timedance.hookmeasure.autolayout.attr.*
import java.util.*

class AutoLayoutInfo {
    private val autoAttrs = ArrayList<AutoAttr>()

    internal fun addAttr(autoAttr: AutoAttr) {
        autoAttrs.add(autoAttr)
    }

    internal fun fillAttrs(view: View) {
        for (autoAttr in autoAttrs) {
            autoAttr.apply(view)
        }
    }

    companion object {
        internal fun getAttrFromView(view: View): AutoLayoutInfo? {
            val params = view.layoutParams ?: return null
            val autoLayoutInfo = AutoLayoutInfo()

            // width & height
            if (params.width > 0) {
                autoLayoutInfo.addAttr(WidthAttr(params.width))
            }

            if (params.height > 0) {
                autoLayoutInfo.addAttr(HeightAttr(params.height))
            }

            //margin
            if (params is ViewGroup.MarginLayoutParams) {
                autoLayoutInfo.addAttr(MarginLeftAttr(params.leftMargin))
                autoLayoutInfo.addAttr(MarginTopAttr(params.topMargin))
                autoLayoutInfo.addAttr(MarginRightAttr(params.rightMargin))
                autoLayoutInfo.addAttr(MarginBottomAttr(params.bottomMargin))
                autoLayoutInfo.addAttr(MarginStartAttr(params.marginStart))
                autoLayoutInfo.addAttr(MarginEndAttr(params.marginEnd))
            }

            //padding
            autoLayoutInfo.addAttr(PaddingLeftAttr(view.paddingLeft))
            autoLayoutInfo.addAttr(PaddingTopAttr(view.paddingTop))
            autoLayoutInfo.addAttr(PaddingRightAttr(view.paddingRight))
            autoLayoutInfo.addAttr(PaddingBottomAttr(view.paddingBottom))

            //minWidth ,maxWidth , minHeight , maxHeight
            autoLayoutInfo.addAttr(MinWidthAttr(MinWidthAttr.getMinWidth(view)))
            autoLayoutInfo.addAttr(MaxWidthAttr(MaxWidthAttr.getMaxWidth(view)))
            autoLayoutInfo.addAttr(MinHeightAttr(MinHeightAttr.getMinHeight(view)))
            autoLayoutInfo.addAttr(MaxHeightAttr(MaxHeightAttr.getMaxHeight(view)))

            //textsize
            if (view is TextView) {
                autoLayoutInfo.addAttr(TextSizeAttr(view.textSize.toInt()))
                autoLayoutInfo.addAttr(LineSpacingExtraAttr(view.lineSpacingExtra.toInt()))
            }
            return autoLayoutInfo
        }
    }
}