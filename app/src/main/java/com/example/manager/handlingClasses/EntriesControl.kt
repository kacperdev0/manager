package com.example.manager.handlingClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.manager.R

class EntriesControl(context: Context, data: List<SingleEntry>) :
    ArrayAdapter<SingleEntry>(context, 0, data) {
        var selectedPostion = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.entry_item, parent, false)

        val data = getItem(position)

        val moodName = view.findViewById<TextView>(R.id.mood_name)
        val date = view.findViewById<TextView>(R.id.date)

        moodName.text = data?.mood?.name
        date.text = data?.date.toString()

        return view
    }
}