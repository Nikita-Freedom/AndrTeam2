package com.hackaton.andrteam.alcoholdiary.view.report.suggestions

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.hackaton.andrteam.alcoholdiary.R

class FragmentSuggestion : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val key = pref.getInt("drink", 0)
        return if (key == 0) inflater.inflate(R.layout.fragment_rec2, container, false)
        else inflater.inflate(R.layout.fragment_rec_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}