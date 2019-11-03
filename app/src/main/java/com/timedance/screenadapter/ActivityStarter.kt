package com.timedance.screenadapter

import android.app.Activity
import android.content.Intent
import com.timedance.enumscreensize.EnumScreenSizeActivity
import com.timedance.enumsmallestwidth.EnumSmallestWidthActivity
import com.timedance.hookdimension.HookDimensionActivity
import com.timedance.hookmeasure.HookMeasureActivity
import com.timedance.original.OriginalActivity

/**
 * Author: xiaoshilin
 * Date: 2019/10/23
 */
fun Activity.startToOriginal() {
    val intent = Intent(this, OriginalActivity::class.java)
    startActivity(intent)
}

fun Activity.startToEnumScreenSize() {
    val intent = Intent(this, EnumScreenSizeActivity::class.java)
    startActivity(intent)
}

fun Activity.startToEnumSmallestWidth() {
    val intent = Intent(this, EnumSmallestWidthActivity::class.java)
    startActivity(intent)
}

fun Activity.startToHookMeasure() {
    val intent = Intent(this, HookMeasureActivity::class.java)
    startActivity(intent)
}

fun Activity.startToHookDimension() {
    val intent = Intent(this, HookDimensionActivity::class.java)
    startActivity(intent)
}
