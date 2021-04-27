package com.hackaton.andrteam.alcoholdiary.ui.detailday

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackaton.andrteam.alcoholdiary.NavigationActivity
import com.hackaton.andrteam.alcoholdiary.R
import com.hackaton.andrteam.alcoholdiary.data.model.Drink
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import com.hackaton.andrteam.alcoholdiary.view.report.MainScreenActivity
import kotlinx.android.synthetic.main.fragment_detail_day.*
import kotlinx.android.synthetic.main.fragment_detail_day.detailDayOverlay
import kotlinx.android.synthetic.main.fragment_detail_day.infoDetailTextView
import kotlinx.android.synthetic.main.fragment_detail_day.view.*
import kotlin.random.Random

class DetailDayFragment : Fragment() {

    val listDrinks = mutableListOf<Drink>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.text = "${arguments?.getInt("DAY_NUM")} марта"
        var daysAdapter: DrinksListAdapter
        view.findViewById<RecyclerView>(R.id.recyclerViewDrinks).apply {
            this.layoutManager = LinearLayoutManager(this.context)
            this.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
            daysAdapter = DrinksListAdapter().apply {
                arguments?.getInt("DAY_NUM")?.let {
                    if (it > 14) {
                        detailDayOverlay.visibility = View.VISIBLE
                        infoDetailTextView.visibility = View.VISIBLE
                        cardView.isEnabled = false
                    } else {
                        val items = getDrinksByNumber(it)
                        if (items.isNotEmpty()) {
                            submitList(items)
                            ratingBar.rating = 50f
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Ты в этот день не пил, даже не вздувай тут что-то искать, а ну выходи отдсюда",
                                Toast.LENGTH_LONG
                            ).show()
                            cardView.isEnabled = false
                        }
                    }
                }
            }
            this.adapter = daysAdapter
        }

        view.findViewById<View>(R.id.btn_back_to_calendar)?.setOnClickListener {
            (activity as MainScreenActivity).findNavController(R.id.nav_host_fragment)
                .popBackStack()
        }
            view.findViewById<View>(R.id.btn_add_drink).setOnClickListener {
                val nameDr = view.spinnerDrinks.selectedItem.toString()
                val volume = (view.spinnerMl.selectedItem.toString()).toInt()
                var degree = nameDr.substringAfter('(')
                degree = degree.substringBefore('%')
                listDrinks.add(Drink(nameDr, degree.toDouble(), volume))
                loadDataToAdapter(daysAdapter)
            }

        view.findViewById<TextView>(R.id.playToast).setOnClickListener {
            Thread {
                    kotlin.run {
                        val mp = MediaPlayer.create(context, R.raw.tost2);
                        mp.start();
                    }
                }.start()
        }

    }

    private fun loadDataToAdapter(adapter: DrinksListAdapter) {
        adapter.submitList(listDrinks)
        adapter.notifyDataSetChanged()
    }

    private fun updateDrinkDetailsInfo(drink: Drink) {
        view?.findViewById<TextView>(R.id.tvDrink)
            ?.text = drink.name

        view?.findViewById<TextView>(R.id.tvMl)
            ?.text = "$(drink.volume.toString()) мл"
    }

    private fun getDrinksByNumber(number: Int): List<Drink> {
        return when (number) {
            14 -> listOf(Drink("Пиво", 4.0, 1))
            13 -> listOf(
                Drink("Пиво", 4.0, 2),
                Drink("Водка", 40.0, 1),
                Drink("Вино", 10.2, 1)
            )
            11 -> listOf(
                Drink("Пиво", 4.1, 2),
                Drink("Водка", 40.2, 1),
                Drink("Кефир", 1.3, 1)
            )
            5 -> listOf(
                Drink("Пиво", 44.6, 2),
                Drink("Вино", 12.44, 1)
            )
            7 -> listOf(
                Drink("Текила", 40.5, 2),
                Drink("Вино", 12.8, 1)
            )
            2 -> listOf(
                Drink("Mintu", 45.4, 1),
                Drink("Вино", 12.3, 1)
            )
            1 -> listOf(
                Drink("Пиво", 4.4, 33),
            )
            6 -> listOf(
                Drink("Вино", 12.3, 1)
            )
            else -> {
                emptyList()
            }
        }
    }
}