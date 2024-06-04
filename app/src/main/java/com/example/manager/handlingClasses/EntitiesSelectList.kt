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
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date

class EntitiesSelectList(context: Context, data: List<SingleEntry>) :
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

        val am = AllMoods("MoodsData", context)
        am.loadData()
        val moods_list = am.arrayOfSingleMoods()

        println(moods_list)
        println(data?.mood_id)
        val mood = moods_list.find { it.id == data?.mood_id }
        moodName.text = mood?.name

        if (data != null) {
            date.text = data.date
        }
        return view
    }
}