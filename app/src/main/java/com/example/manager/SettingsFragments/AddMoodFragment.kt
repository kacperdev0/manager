package com.example.manager.SettingsFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.manager.R

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

        view.findViewById<Button>(R.id.cancel_button).setOnClickListener {
            findNavController().navigate(R.id.MoodEditionFragment)
        }

        view.findViewById<Button>(R.id.commit_button).setOnClickListener {

        }
    }
}