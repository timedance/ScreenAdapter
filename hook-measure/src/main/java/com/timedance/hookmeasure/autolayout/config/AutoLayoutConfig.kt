package com.timedance.hookmeasure.autolayout.config

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.timedance.utils.getScreenHeight
import com.timedance.utils.getScreenWidth
import kotlin.math.min

/**
 * Created by zhy on 15/11/18.
 */
@Suppress("unused")
internal class AutoLayoutConfig private constructor() {
    var screenWidth: Int = 0
        private set
    var designWidth: Int = 0
        private set

    fun checkParams() {
        if (designWidth <= 0) {
            throw RuntimeException(
                "you must set $KEY_DESIGN_WIDTH in your manifest file."
            )
        }
    }

    fun init(context: Context) {
        if (screenWidth <= 0) { //不重复获取
            getMetaData(context)
        }

        screenWidth = min(context.getScreenWidth(), context.getScreenHeight())
    }

    private fun getMetaData(context: Context) {
        val packageManager = context.packageManager
        val applicationInfo: ApplicationInfo?
        try {
            applicationInfo = packageManager.getApplicationInfo(
                context.packageName, PackageManager.GET_META_DATA
            )
            if (applicationInfo?.metaData != null) {
                designWidth = applicationInfo.metaData.get(KEY_DESIGN_WIDTH) as Int
            }
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException(
                "you must set $KEY_DESIGN_WIDTH in your manifest file.", e
            )
        }

    }

    companion object {
        val instance: AutoLayoutConfig by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AutoLayoutConfig()
        }
        private const val KEY_DESIGN_WIDTH = "design_width"
    }

}
