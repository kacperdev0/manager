package com.example.manager

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.manager.handlingClasses.AllMoods
import com.example.manager.handlingClasses.FileOperation
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddEntityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEntityFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_entity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spinner = view.findViewById<Spinner>(R.id.moodSpinner)
        val selectDate_Button = view.findViewById<Button>(R.id.selectDateButton)
        val datePreview_TextView = view.findViewById<TextView>(R.id.selectedDate)
        val cancel_Button = view.findViewById<Button>(R.id.cancel_button)
        val commit_Button = view.findViewById<Button>(R.id.commit_button)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        var datePickerDiolog = DatePickerDialog(
            view.context,
            { _, selectedYear, selectedMonth, selectedDay ->
                datePreview_TextView.text = formatSelectedDate(selectedYear, selectedMonth, selectedDay)
            },
            year, month, day
        )

        val allMoods = AllMoods("MoodsData", view.context)
        allMoods.loadData()

        val fo = FileOperation("EntriesData", view.context)
        fo.loadData()

        val moodsArray = allMoods.arrayOfSingleMoods()

        val adapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item,
            allMoods.arrayOfMoods()
        )
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)


        selectDate_Button.setOnClickListener {
            datePickerDiolog.show()
            datePickerDiolog.datePicker
        }

        cancel_Button.setOnClickListener {
            findNavController().navigate(R.id.HomeFragment)
        }

        commit_Button.setOnClickListener {
            fo.addSingleEntry(
                datePreview_TextView.text.toString(),
                moodsArray[spinner.selectedItemPosition].id
            )

            findNavController().navigate(R.id.HomeFragment)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun formatSelectedDate(year: Int, month: Int, dayOfMonth: Int): String {

        val year = year.toString()
        val month = String.format("%02d", month)
        val day = String.format("%02d", dayOfMonth)

        return day + "-" + month + "-" + year
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddEntityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddEntityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}