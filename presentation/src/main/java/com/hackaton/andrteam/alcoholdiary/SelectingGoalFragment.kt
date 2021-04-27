package com.hackaton.andrteam.alcoholdiary

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_selecting_goal.*

class SelectingGoalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selecting_goal, container, false)
    }

    override fun onStart() {
        super.onStart()
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        buttonDrink.setOnClickListener{

            /*  1 - Drink   0 - NoDrink  */
            pref.edit().putInt("drink", 1).apply()
            (activity as MainActivity).navController.navigate(R.id.action_selectingGoalFragment_to_mainActivity)
        }

        buttonNoDrink.setOnClickListener{
            pref.edit().putInt("drink", 0).apply()
            (activity as MainActivity).navController.navigate(R.id.action_selectingGoalFragment_to_mainActivity)
        }
    }

}