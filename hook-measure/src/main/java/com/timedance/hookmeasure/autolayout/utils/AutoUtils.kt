package com.timedance.hookmeasure.autolayout.utils

import android.view.View
import com.timedance.hookmeasure.R
import com.timedance.hookmeasure.autolayout.AutoLayoutInfo
import com.timedance.hookmeasure.autolayout.config.AutoLayoutConfig

/**
 * Created by zhy on 15/12/4.
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
object AutoUtils {

    internal val percentWidth1px: Float
        get() {
            val screenWidth = AutoLayoutConfig.instance.screenWidth
            val designWidth = AutoLayoutConfig.instance.designWidth
            return 1.0f * screenWidth / designWidth
        }

    /**
     * 会直接将view的LayoutParams上设置的width，height直接进行百分比处理
     *
     * @param view
     */
    fun auto(view: View) {
        AutoLayoutInfo.getAttrFromView(view)?.apply {
            fillAttrs(view)
        }
    }

    fun autoed(view: View): Boolean {
        val tag = view.getTag(R.id.id_tag_autolayout_size)
        if (tag != null) {
            return true
        }
        view.setTag(R.id.id_tag_autolayout_size, "Just Identify")
        return false
    }

    internal fun getPercentWidthSize(value: Int): Int {
        val screenWidth = AutoLayoutConfig.instance.screenWidth
        val designWidth = AutoLayoutConfig.instance.designWidth

        val res = value * screenWidth
        return if (res % designWidth == 0) {
            res / designWidth
        } else {
            res / designWidth + 1
        }
    }
}
