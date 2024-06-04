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
        return inflater.inflate(R.layout.fragment_add_mood, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput = view.findViewById<TextInputEditText>(R.id.mood_name_input)
        val vibeSlider = view.findViewById<SeekBar>(R.id.vibe_seekbar)

        val am = AllMoods("MoodsData", view.context)
        am.loadData()

        val id: Int

        val indexToEdit = arguments?.getInt("ARG_Index") ?: -1
        if (indexToEdit != -1) {
            val moodToEdit: SingleMood = am.getSinlgeMood(indexToEdit)
            nameInput.setText(moodToEdit.name)
            vibeSlider.progress = moodToEdit.vibe
            id = moodToEdit.id
        } else {
            id = am.nextId()
        }

        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            findNavController().navigate(R.id.MoodEditionFragment)
        }

        view.findViewById<Button>(R.id.commit_button).setOnClickListener {
            val name = nameInput.text.toString()
            val vibe = vibeSlider.progress
            am.addMood(SingleMood(id, name, vibe), indexToEdit)

            findNavController().navigate(R.id.SettingsFragment)
        }
    }
}