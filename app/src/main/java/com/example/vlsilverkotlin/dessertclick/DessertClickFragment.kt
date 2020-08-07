package com.example.vlsilverkotlin.dessertclick

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.DessertclickFragmentBinding


class DessertClickFragment : Fragment() {
    //    private var revenue = 0
//    private var dessertSold = 0
//    private var currentDessertClick = allDessertClick[(allDessertClick.indices).random()]
//    private var dessertName = currentDessertClick.name
    private lateinit var binding: DessertclickFragmentBinding

//    private lateinit var binding: DessertclickFragmentBinding
    private lateinit var viewModel: ViewModelDessertClickFragment

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
        viewModel = ViewModelProvider(this).get(ViewModelDessertClickFragment::class.java)
        binding.dessertViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        Timber.i("onCreateView Called")
//        Set value start of the view
//        binding.revenue = revenue
//        binding.amountSold = dessertSold
//        binding.dessertButton.setBackgroundResource(currentDessertClick.imgId)
//        binding.dessertButton.setOnClickListener {
////            revenue += currentDessertClick.price
////            dessertSold++
//            viewModel.setCurrentAmount()
//            binding.revenue = viewModel.revenue
//            binding.amountSold = viewModel.dessertSold
////            binding.revenue = viewModel.revenue
//            binding.amountSold = viewModel.dessertSold
//            viewModel.setNewDessert()
//            binding.dessertButton.setBackgroundResource(viewModel.currentDessertClick.imgId)
//            setNewDessert()
//        }
        (activity as AppCompatActivity).supportActionBar?.title = "Dessert Click App"
        setHasOptionsMenu(true)
//        binding.amountSold = viewModel.dessertSold
//        binding.revenue = viewModel.revenue
//        binding.dessertButton.setBackgroundResource(viewModel.currentDessertClick.imgId)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        if (shareIntent().resolveActivity(requireActivity().packageManager) == null) {
            menu.findItem(R.id.share).isVisible = false
            Toast.makeText(context, R.string.sharing_not_available, Toast.LENGTH_SHORT).show()
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

    private fun shareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_text, viewModel.revenue.value,viewModel.dessertSold.value)
            )
        return shareIntent
    }

//    private fun setNewDessert() {
//        var newDessertClick = currentDessertClick
//        for (item in allDessertClick) {
//            if (dessertSold >= item.startProductionAmount) {
//                newDessertClick = item
//            } else break
//        }
//        if (newDessertClick != currentDessertClick) {
//            currentDessertClick = newDessertClick
//            binding.dessertButton.setBackgroundResource(currentDessertClick.imgId)
//        }
//    }

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

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putInt(KEY_REVENUE, revenue)
//        outState.putInt(KEY_DESSERT_SOLD, dessertSold)
//        outState.putInt(KEY_TIMER_SECONDS, dessertTimer.secondsCount)
//        outState.putString(KEY_DESSERT_NAME, currentDessertClick.name)
//        super.onSaveInstanceState(outState)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        if (null != savedInstanceState) {
//            revenue = savedInstanceState.getInt(KEY_REVENUE, 0)
//            dessertSold = savedInstanceState.getInt(KEY_DESSERT_SOLD, 0)
//            dessertTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
//            dessertName = savedInstanceState.getString(KEY_DESSERT_NAME, "")
//            for (item in allDessertClick) {
//                if (dessertName == item.name) {
//                    currentDessertClick = item
//                    break
//                }
//            }
//        }
//    }
}