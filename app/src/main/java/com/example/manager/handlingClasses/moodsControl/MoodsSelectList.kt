package com.example.manager.handlingClasses.moodsControl

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.manager.R
import com.example.manager.handlingClasses.SingleMood

class MoodsSelectList(context: Context, data: MutableList<SingleMood>) :
    ArrayAdapter<SingleMood>(context, 0, data) {

    var selectedPostion = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.mood_item, parent, false)
        val data = getItem(position)

        val textName = view.findViewById<TextView>(R.id.name)
        val textVibe = view.findViewById<TextView>(R.id.vibe)

        if (position == selectedPostion) {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            textName.setTextColor(Color.WHITE)
            textVibe.setTextColor(Color.WHITE)
        } else {
            view.setBackgroundColor(Color.TRANSPARENT)
            textName.setTextColor(Color.BLACK)
            textVibe.setTextColor(Color.BLACK)
        }

        view.setOnClickListener {
            selectedPostion = position
            notifyDataSetChanged()
        }

        textName.text = data?.name
        textVibe.text = "${data?.vibe.toString()}%"

        return view
    }
}