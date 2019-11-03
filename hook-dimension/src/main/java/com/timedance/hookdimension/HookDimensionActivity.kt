package com.timedance.hookdimension

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.timedance.utils.getScreenAbsHeight
import com.timedance.utils.getScreenAbsWidth
import kotlinx.android.synthetic.main.activity_hook_dimension.*

class HookDimensionActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        adaptDensityDpi()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hook_dimension)
        recyclerView.adapter = Adapter()

        val sysMetrics = Resources.getSystem().displayMetrics
        tvSize.text = "${getScreenAbsWidth()}x${getScreenAbsHeight()}，修改前${sysMetrics.densityDpi}dpi，修改后${resources.displayMetrics.densityDpi}dpi"
    }

    override fun onDestroy() {
        unAdaptDensityDpi()
        super.onDestroy()
    }

    private fun adaptDensityDpi() {
        val targetDpi = resources.displayMetrics.widthPixels * 160 / 360
        val sysMetrics = Resources.getSystem().displayMetrics

        resources.displayMetrics.run {
            densityDpi = targetDpi
            density = targetDpi / 160f
            scaledDensity = density * sysMetrics.scaledDensity / sysMetrics.density
        }

        application.resources.displayMetrics.run {
            densityDpi = targetDpi
            density = targetDpi / 160f
            scaledDensity = density * sysMetrics.scaledDensity / sysMetrics.density
        }
    }

    private fun unAdaptDensityDpi() {
        /**
         * 这里直接使用sysMetrics进行恢复，原因有二
         * 1.不用记录中间值
         * 2.在使用应用时如果修改了系统字体大小，sysMetrics会同步修改，不用再监听registerComponentCallbacks
         */
        val sysMetrics = Resources.getSystem().displayMetrics

        resources.displayMetrics.run {
            densityDpi = sysMetrics.densityDpi
            density = sysMetrics.density
            scaledDensity = sysMetrics.scaledDensity
        }

        application.resources.displayMetrics.run {
            densityDpi = sysMetrics.densityDpi
            density = sysMetrics.density
            scaledDensity = sysMetrics.scaledDensity
        }
    }

    private class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return object : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hook_dimension, parent, false)) {}
        }
    }
}
