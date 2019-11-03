package com.timedance.hookmeasure.autolayout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.timedance.hookmeasure.autolayout.utils.AutoLayoutHelper

/**
 * Author: xiaoshilin
 * Date: 2019/10/24
 */
class AutoLinearLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    private val mHelper = AutoLayoutHelper(this)

    override fun generateLayoutParams(attrs: AttributeSet): LinearLayout.LayoutParams? {
        if (isInEditMode) {
            return LinearLayout.LayoutParams(context, attrs)
        }
        return LayoutParams(context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!isInEditMode) {
            mHelper.adjustChildren()
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    @Suppress("unused")
    class LayoutParams : LinearLayout.LayoutParams, AutoLayoutHelper.AutoLayoutParams {
        override var autoLayoutInfo: AutoLayoutInfo? = null

        constructor(c: Context, attrs: AttributeSet) : super(c, attrs) {
            autoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs)
        }

        constructor(width: Int, height: Int) : super(width, height)

        constructor(source: ViewGroup.LayoutParams) : super(source)

        constructor(source: ViewGroup.MarginLayoutParams) : super(source)

        constructor(source: FrameLayout.LayoutParams) : super(source as ViewGroup.MarginLayoutParams)

        constructor(source: LayoutParams) : this(source as LinearLayout.LayoutParams) {
            autoLayoutInfo = source.autoLayoutInfo
        }

    }
}