package com.example.manager.handlingClasses.moodsControl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.manager.R
import com.example.manager.handlingClasses.SingleMood

class MoodsSelectList(context: Context, data: MutableList<SingleMood>) :
    ArrayAdapter<SingleMood>(context, 0, data) {

    var selectedPostion = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.mood_item, parent, false)
        val data = getItem(position)

        val textName = view.findViewById<TextView>(R.id.name)
        val textType = view.findViewById<TextView>(R.id.type)

        textName.text = data?.name
        textType.text = data?.id.toString()

        return view
    }
}