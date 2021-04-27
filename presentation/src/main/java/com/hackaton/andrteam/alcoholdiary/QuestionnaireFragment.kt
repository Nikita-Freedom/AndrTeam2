package com.hackaton.andrteam.alcoholdiary

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_questionnaire.*
import java.util.*

class QuestionnaireFragment : Fragment() {

    private var mDisplayDate: TextView? = null
    private var mDateSetListener: OnDateSetListener? = null
    private var date: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questionnaire, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDisplayDate = view.findViewById(R.id.tvDate) as TextView

        mDisplayDate?.setOnClickListener(View.OnClickListener {
            val cal = Calendar.getInstance()
            val year = cal[Calendar.YEAR]
            val month = cal[Calendar.MONTH]
            val day = cal[Calendar.DAY_OF_MONTH]
            val dialog = DatePickerDialog(
                view.context,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        })

        mDateSetListener =
            OnDateSetListener { datePicker, year, month, day ->
                var month = month
                month = month + 1
                date = "$month/$day/$year"
                view.findViewById<TextView>(R.id.tvDateUser).setText("Дата рождения: $date")
            }
    }

    @SuppressLint("CommitPrefEdits")
    override fun onStart() {
        super.onStart()

        buttonStartDrink.setOnClickListener {
            val name = editTextNameUser.text.toString().trim()
            val weight = spinnerWeigth.selectedItem.toString()
            val growth = spinnerGrowth.selectedItem.toString()

            val id: Int = radioGroup.checkedRadioButtonId
            val sex = when (id) {
                R.id.checkBoxWomen -> {
                    "w"
                }
                else -> {
                    "m"
                }
            }
            val dateOfBirth = date

            val prefName: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(view?.context)
            val prefWeight: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(view?.context)
            val prefGrowth: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(view?.context)
            val prefSex: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(view?.context)

            prefName.edit().putString("name", name)
            prefWeight.edit().putString("weight", weight)
            prefGrowth.edit().putString("growth", growth)
            prefSex.edit().putString("sex", sex)

            (activity as MainActivity).navController.navigate(R.id.action_questionnaireFragment_to_selectingGoalFragment)
        }
    }

}