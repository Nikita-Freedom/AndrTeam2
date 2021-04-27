package com.hackaton.andrteam.alcoholdiary.view.report.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.andrteam.alcoholdiary.NavigationActivity
import com.hackaton.andrteam.alcoholdiary.R
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_daily.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.buttonInput
import kotlinx.android.synthetic.main.fragment_register.*
import com.hackaton.andrteam.alcoholdiary.di.StorageProvider
import com.hackaton.andrteam.alcoholdiary.view.report.MainScreenActivity
import kotlinx.android.synthetic.main.fragment_daily.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentDaily : Fragment() {

    private val viewModel: DailyViewModel by lazy {
        ViewModelProvider(this, DailyCalendarViewModelFactory())
            .get(DailyViewModel::class.java)
    }

    private val sharedPreferences by lazy { StorageProvider.provideStorageManager(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            if (sharedPreferences.isSessionStarted()) {
                view.findViewById<View>(R.id.playButtonView).visibility = View.VISIBLE
                view.findViewById<View>(R.id.stopButtonView).visibility = View.INVISIBLE
            }
        }

        viewModel.daysLiveData.observe(viewLifecycleOwner) {
            view.findViewById<RecyclerView>(R.id.dailyCalendarRecyclerView).apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = DailyCalendarRecyclerViewAdapter(it) {
                    (activity as MainScreenActivity).findNavController(R.id.nav_host_fragment)
                        .navigate(
                            R.id.action_fragmentDaily_to_detailDayFragment,
                            bundleOf(Pair("DAY_NUM", it))
                        )
                }.apply { scrollToPosition(10) }
            }
        }

        viewModel.launch()

        view.findViewById<View>(R.id.playButtonView).setOnClickListener {
            lifecycleScope.launch {
                sharedPreferences.setIsSessionStarted(true)
            }
            view.findViewById<View>(R.id.stopButtonView).visibility = View.VISIBLE
            it.visibility = View.INVISIBLE
        }

        view.findViewById<View>(R.id.stopButtonView).setOnClickListener {
            lifecycleScope.launch {
                sharedPreferences.setIsSessionStarted(false)
            }
            view.findViewById<View>(R.id.playButtonView).visibility = View.VISIBLE
            it.visibility = View.INVISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPreferences.setIsSessionStarted(false)
    }
}