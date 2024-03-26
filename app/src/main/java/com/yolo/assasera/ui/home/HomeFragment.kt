package com.yolo.assasera.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.yolo.assasera.R
import com.yolo.assasera.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    // on below line we are creating a
    // variable for our view pager
    lateinit var viewPager: ViewPager

    // on below line we are creating a variable
    // for our slider adapter and slider list
    lateinit var sliderAdapter: SliderAdapter
    lateinit var sliderList: ArrayList<SliderData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // on below line we are initializing our slider list.
        sliderList = ArrayList()

        // on below line we are adding data to our list
        sliderList.add(SliderData(getString(R.string.post_requests )))
        sliderList.add(SliderData("Text 2" ))
        sliderList.add(SliderData("Text 3" ))


        // on below line we are adding slider list
        // to our adapter class.
        sliderAdapter = context?.let { SliderAdapter(it, sliderList) }!!

        binding.idViewPager.adapter = sliderAdapter

        // creating a method for view pager for on page change listener.
        var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                // we are calling our dots method to
                // change the position of selected dots.

                // on below line we are checking position and updating text view text color.
                if (position == 0) {
                    binding.idTVSlideOne.setTextColor(resources.getColor(R.color.blue))
                    binding.idTVSlideTwo.setTextColor(resources.getColor(R.color.grey))
                    binding.idTVSlideThree.setTextColor(resources.getColor(R.color.grey))

                } else if (position == 1) {
                    binding.idTVSlideOne.setTextColor(resources.getColor(R.color.grey))
                    binding.idTVSlideTwo.setTextColor(resources.getColor(R.color.blue))
                    binding.idTVSlideThree.setTextColor(resources.getColor(R.color.grey))
                } else {
                    binding.idTVSlideOne.setTextColor(resources.getColor(R.color.grey))
                    binding.idTVSlideTwo.setTextColor(resources.getColor(R.color.grey))
                    binding.idTVSlideThree.setTextColor(resources.getColor(R.color.blue))
                }
            }

            // below method is use to check scroll state.
            override fun onPageScrollStateChanged(state: Int) {}
        }
        binding.idViewPager.addOnPageChangeListener(viewListener)

            return binding.root
    }

}