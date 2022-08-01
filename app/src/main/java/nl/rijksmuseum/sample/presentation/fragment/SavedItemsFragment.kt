package nl.rijksmuseum.sample.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import nl.rijksmuseum.sample.R
import nl.rijksmuseum.sample.databinding.FragmentSavedBinding

class SavedItemsFragment : Fragment() {
    private val binding : FragmentSavedBinding by lazy { FragmentSavedBinding.inflate(layoutInflater) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    private inner class ScreenSlidePagerAdapter() : FragmentStateAdapter(this) {
//
//        override fun getItemCount(): Int = NUM_PAGES
//        override fun createFragment(position: Int): Fragment = ScreenSlidePageFragment()
//    }
}