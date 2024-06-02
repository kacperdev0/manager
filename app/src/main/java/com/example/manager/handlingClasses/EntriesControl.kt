package com.example.manager.handlingClasses

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.manager.R

class EntriesControl(context: Context, data: List<SingleEntry>) :
    ArrayAdapter<SingleEntry>(context, 0, data) {
        var selectedPostion = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.entry_item, parent, false)
        val moodName = view.findViewById<TextView>(R.id.mood_name)
        val date = view.findViewById<TextView>(R.id.date)

        val data = getItem(position)

        view.setOnClickListener {
            selectedPostion = position
            notifyDataSetChanged()
        }

        if (position == selectedPostion) {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            moodName.setTextColor(Color.WHITE)
            date.setTextColor(Color.WHITE)
        } else {
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            moodName.setTextColor(Color.BLACK)
            date.setTextColor(Color.BLACK)
        }

        moodName.text = data?.mood?.name
        date.text = data?.date.toString()

        return view
    }
}