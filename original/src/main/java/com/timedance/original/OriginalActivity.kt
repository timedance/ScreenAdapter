package com.timedance.original

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.timedance.utils.getScreenAbsHeight
import com.timedance.utils.getScreenAbsWidth
import kotlinx.android.synthetic.main.activity_original.*

class OriginalActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_original)
        recyclerView.adapter = Adapter()
        tvSize.text = "${getScreenAbsWidth()}x${getScreenAbsHeight()}，${resources.displayMetrics.densityDpi}dpi"
    }

    private class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return object : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_original, parent, false)) {}
        }
    }
}
