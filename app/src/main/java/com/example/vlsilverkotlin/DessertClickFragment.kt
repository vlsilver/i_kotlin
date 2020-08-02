package com.example.vlsilverkotlin

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.DessertclickFragmentBinding
import timber.log.Timber

const val KEY_REVENUE = "key_revenue"
const val KEY_DESSERT_SOLD = "key_dessert_sold"
const val KEY_TIMER_SECONDS = "key_timer_seconds"
const val KEY_DESSERT_NAME = "key_dessert_name"


class DessertClickFragment : Fragment() {
    private var revenue = 0
    private var dessertSold = 0
    private var currentDessertClick = allDessertClick[(allDessertClick.indices).random()]
    private var dessertName = currentDessertClick.name
    lateinit var binding: DessertclickFragmentBinding
    private var dessertTimer = DessertTimer(this.lifecycle)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dessertclick_fragment,
            container,
            false
        )
//        Timber.i("onCreateView Called")
//        Set value start of the view
        binding.revenue = revenue
        binding.amountSold = dessertSold
        binding.dessertButton.setBackgroundResource(currentDessertClick.imgId)
        binding.dessertButton.setOnClickListener {
            revenue += currentDessertClick.price
            dessertSold++
            binding.revenue = revenue
            binding.amountSold = dessertSold
            setNewDessert()
        }
        dessertTimer
        (activity as AppCompatActivity).supportActionBar?.title = "Dessert Click App"
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        if (null == shareIntent().resolveActivity(activity!!.packageManager)) {
            menu.findItem(R.id.share).isVisible = false
            Toast.makeText(context, getString(R.string.sharing_not_available), Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                startActivity(shareIntent())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setNewDessert() {
        var newDessertClick = currentDessertClick
        for (item in allDessertClick) {
            if (dessertSold >= item.startProductionAmount) {
                newDessertClick = item
            } else break
        }
        if (newDessertClick != currentDessertClick) {
            currentDessertClick = newDessertClick
            binding.dessertButton.setBackgroundResource(currentDessertClick.imgId)
        }
    }

    //    private fun onShare() {
//        val shareIntent = ShareCompat.IntentBuilder.from(activity!!)
//            .setText(getString(R.string.share_text, dessertSold, revenue))
//            .setType("text/plain")
//            .intent
//        try {
//            startActivity(shareIntent)
//        } catch (ex: ActivityNotFoundException) {
//            Toast.makeText(context, getString(R.string.sharing_not_available),
//                Toast.LENGTH_LONG).show()
//        }
//    }
    private fun shareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, dessertSold, revenue))
        return shareIntent
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_REVENUE, revenue)
        outState.putInt(KEY_DESSERT_SOLD, dessertSold)
        outState.putInt(KEY_TIMER_SECONDS, dessertTimer.secondsCount)
        outState.putString(KEY_DESSERT_NAME, currentDessertClick.name)
//        Timber.i("onSaveInstanceState Called")
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (null != savedInstanceState) {
//            revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
//            dessertSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0)
            dessertTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
//            dessertName = savedInstanceState.getString(KEY_DESSERT_NAME, "")
//            for (item in allDessertClick) {
//                if (dessertName == item.name) {
//                    currentDessertClick = item
//                    break
////                    Timber.i("onCreate Called with savedInstanceState")
////                } else {
////                    Timber.i("onCreate Called ")
                }
//            }
//        }
//        Timber.i("onViewStateRestored Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (null != savedInstanceState) {
            revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
            dessertSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0)
            dessertTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
            dessertName = savedInstanceState.getString(KEY_DESSERT_NAME, "")
            for (item in allDessertClick) {
                if (dessertName == item.name) {
                    currentDessertClick = item
                    break
//                    Timber.i("onCreate Called with savedInstanceState")
//                } else {
//                    Timber.i("onCreate Called ")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
//
//        }
//
//        override fun onStop() {
//            super.onStop()
//            Timber.i("onStop Called")
//        }
//
//        override fun onResume() {
//            super.onResume()
//            Timber.i("onResume Called")
//        }
//
//        override fun onPause() {
//            super.onPause()
//            Timber.i("onPause Called")
//        }
//
//
//        override fun onDestroy() {
//            super.onDestroy()
//            Timber.i("onDestroy Called")
//        }
//
//        override fun onDetach() {
//            super.onDetach()
//            Timber.i("onDetach Called")
        }
    }