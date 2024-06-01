package com.example.manager.SettingsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.manager.R
import com.example.manager.handlingClasses.AllMoods
import com.example.manager.handlingClasses.moodsControl.MoodsSelectList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoodEditionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoodEditionFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_mood_edition, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val am = AllMoods("MoodsData", view.context)
        am.loadData()

        val moodsList = view.findViewById<ListView>(R.id.moodsList)
        println(am.moods)
        val allMoodsAdaper = MoodsSelectList(view.context, am.moods)
        moodsList.adapter = allMoodsAdaper

        val bundle = Bundle()

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            bundle.putInt("ARG_Index", -1)
            findNavController().navigate(R.id.AddMoodFragment, bundle)
        }

        view.findViewById<Button>(R.id.editButton).setOnClickListener {
            bundle.putInt("ARG_Index", allMoodsAdaper.selectedPostion)
            findNavController().navigate(R.id.AddMoodFragment, bundle)
        }

        view.findViewById<Button>(R.id.deleteButton).setOnClickListener {
            am.deleteMood(allMoodsAdaper.selectedPostion)
            findNavController().navigate(R.id.MoodEditionFragment)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoodEditionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoodEditionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}