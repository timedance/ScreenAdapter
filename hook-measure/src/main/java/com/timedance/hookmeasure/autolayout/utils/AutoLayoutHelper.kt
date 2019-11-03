/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.timedance.hookmeasure.autolayout.utils

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import com.timedance.hookmeasure.autolayout.AutoLayoutInfo
import com.timedance.hookmeasure.autolayout.attr.*
import com.timedance.hookmeasure.autolayout.config.AutoLayoutConfig
import com.timedance.utils.isPxVal

internal class AutoLayoutHelper(private val mHost: ViewGroup) {

    init {
        AutoLayoutConfig.instance.init(mHost.context)
    }

    fun adjustChildren() {
        AutoLayoutConfig.instance.checkParams()

        for (i in 0 until mHost.childCount) {
            val view = mHost.getChildAt(i)
            val params = view.layoutParams

            if (params is AutoLayoutParams) {
                val info = (params as AutoLayoutParams).autoLayoutInfo
                info?.fillAttrs(view)
            }
        }
    }

    interface AutoLayoutParams {
        val autoLayoutInfo: AutoLayoutInfo?
    }

    companion object {

        private val LL = intArrayOf(
            android.R.attr.textSize,
            android.R.attr.padding,
            android.R.attr.paddingLeft,
            android.R.attr.paddingTop,
            android.R.attr.paddingRight,
            android.R.attr.paddingBottom,
            android.R.attr.layout_width,
            android.R.attr.layout_height,
            android.R.attr.layout_margin,
            android.R.attr.layout_marginLeft,
            android.R.attr.layout_marginTop,
            android.R.attr.layout_marginRight,
            android.R.attr.layout_marginBottom,
            android.R.attr.maxWidth,
            android.R.attr.maxHeight,
            android.R.attr.minWidth,
            android.R.attr.minHeight,
            android.R.attr.layout_marginStart,
            android.R.attr.layout_marginEnd
        )

        private val LL2 = intArrayOf( //不知道为什么，放在LL中无效
            android.R.attr.lineSpacingExtra,
            android.R.attr.paddingStart,
            android.R.attr.paddingEnd
        )

        private const val INDEX_TEXT_SIZE = 0
        private const val INDEX_PADDING = 1
        private const val INDEX_PADDING_LEFT = 2
        private const val INDEX_PADDING_TOP = 3
        private const val INDEX_PADDING_RIGHT = 4
        private const val INDEX_PADDING_BOTTOM = 5
        private const val INDEX_WIDTH = 6
        private const val INDEX_HEIGHT = 7
        private const val INDEX_MARGIN = 8
        private const val INDEX_MARGIN_LEFT = 9
        private const val INDEX_MARGIN_TOP = 10
        private const val INDEX_MARGIN_RIGHT = 11
        private const val INDEX_MARGIN_BOTTOM = 12
        private const val INDEX_MAX_WIDTH = 13
        private const val INDEX_MAX_HEIGHT = 14
        private const val INDEX_MIN_WIDTH = 15
        private const val INDEX_MIN_HEIGHT = 16
        private const val INDEX_MARGIN_START = 17
        private const val INDEX_MARGIN_END = 18

        private const val LINE_SPACING_EXTRA = 0
        private const val INDEX_PADDING_START = 1
        private const val INDEX_PADDING_END = 2

        fun getAutoLayoutInfo(context: Context, attrs: AttributeSet): AutoLayoutInfo {
            val info = AutoLayoutInfo()
            val array = context.obtainStyledAttributes(attrs, LL)

            for (i in 0 until array.indexCount) {
                val index = array.getIndex(i)

                if (!array.peekValue(index).isPxVal()) {
                    continue
                }

                val pxVal: Int
                try {
                    pxVal = array.getDimensionPixelOffset(index, 0)
                } catch (ignore: Exception) { //not dimension
                    continue
                }

                when (index) {
                    INDEX_TEXT_SIZE -> info.addAttr(TextSizeAttr(pxVal))
                    INDEX_PADDING -> info.addAttr(PaddingAttr(pxVal))
                    INDEX_PADDING_LEFT -> info.addAttr(PaddingLeftAttr(pxVal))
                    INDEX_PADDING_TOP -> info.addAttr(PaddingTopAttr(pxVal))
                    INDEX_PADDING_RIGHT -> info.addAttr(PaddingRightAttr(pxVal))
                    INDEX_PADDING_BOTTOM -> info.addAttr(PaddingBottomAttr(pxVal))
                    INDEX_WIDTH -> info.addAttr(WidthAttr(pxVal))
                    INDEX_HEIGHT -> info.addAttr(HeightAttr(pxVal))
                    INDEX_MARGIN -> info.addAttr(MarginAttr(pxVal))
                    INDEX_MARGIN_LEFT -> info.addAttr(MarginLeftAttr(pxVal))
                    INDEX_MARGIN_TOP -> info.addAttr(MarginTopAttr(pxVal))
                    INDEX_MARGIN_RIGHT -> info.addAttr(MarginRightAttr(pxVal))
                    INDEX_MARGIN_BOTTOM -> info.addAttr(MarginBottomAttr(pxVal))
                    INDEX_MAX_WIDTH -> info.addAttr(MaxWidthAttr(pxVal))
                    INDEX_MAX_HEIGHT -> info.addAttr(MaxHeightAttr(pxVal))
                    INDEX_MIN_WIDTH -> info.addAttr(MinWidthAttr(pxVal))
                    INDEX_MIN_HEIGHT -> info.addAttr(MinHeightAttr(pxVal))
                    INDEX_MARGIN_START -> info.addAttr(MarginStartAttr(pxVal))
                    INDEX_MARGIN_END -> info.addAttr(MarginEndAttr(pxVal))
                }
            }
            array.recycle()

            val array2 = context.obtainStyledAttributes(attrs, LL2)
            for (i in 0 until array2.indexCount) {
                val index = array2.getIndex(i)

                if (!array2.peekValue(index).isPxVal()) {
                    continue
                }

                val pxVal: Int
                try {
                    pxVal = array2.getDimensionPixelOffset(index, 0)
                } catch (ignore: Exception) { //not dimension
                    continue
                }

                when (index) {
                    LINE_SPACING_EXTRA -> info.addAttr(LineSpacingExtraAttr(pxVal))
                    INDEX_PADDING_START -> info.addAttr(PaddingStartAttr(pxVal))
                    INDEX_PADDING_END -> info.addAttr(PaddingEndAttr(pxVal))
                }
            }
            array2.recycle()
            return info
        }
    }
}
