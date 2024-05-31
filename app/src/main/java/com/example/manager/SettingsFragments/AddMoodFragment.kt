package com.example.manager.SettingsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.manager.R
import com.example.manager.handlingClasses.AllMoods
import com.example.manager.handlingClasses.SingleMood
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [AddMoodFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMoodFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val am = AllMoods("MoodsData", view.context)
        am.loadData()

        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            findNavController().navigate(R.id.MoodEditionFragment)
        }

        TODO("Handling wrong values in input")
        view.findViewById<Button>(R.id.commit_button).setOnClickListener {
            val name = view.findViewById<TextInputEditText>(R.id.mood_name_input).text.toString()
            val vibe = view.findViewById<SeekBar>(R.id.vibe_seekbar).progress
            am.addMood(SingleMood(am.nextId(), name, vibe))

            findNavController().navigate(R.id.SettingsFragment)
        }
    }
}