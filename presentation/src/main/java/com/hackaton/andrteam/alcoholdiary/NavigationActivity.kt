package com.hackaton.andrteam.alcoholdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hackaton.andrteam.alcoholdiary.ui.detailday.DetailDayFragment
import com.hackaton.andrteam.alcoholdiary.view.report.daily.FragmentDaily
import com.hackaton.andrteam.alcoholdiary.view.report.suggestions.FragmentSuggestion
import kotlinx.android.synthetic.main.activity_main_logic.*
import kotlinx.android.synthetic.main.fragment_daily.*

class NavigationActivity : AppCompatActivity() {


    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_logic)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val calendrar = FragmentDaily()
        val rec = FragmentSuggestion()

        bottomNavigationViewMain?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemDailyId -> makeCurrentFragment(calendrar)
                R.id.itemSuggestionId -> makeCurrentFragment(rec)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
                .commit()
        }

    private fun toDetailFragment() =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, DetailDayFragment())
                .commit()
        }
}