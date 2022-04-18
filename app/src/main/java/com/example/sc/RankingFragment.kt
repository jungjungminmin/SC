package com.example.sc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.sc.databinding.FragmentRankingBinding
import com.google.android.material.tabs.TabLayoutMediator


class RankingFragment : Fragment() {

    private lateinit var typeDramaFragment: TypeDramaFragment
    private lateinit var typeMovieFragment: TypeMovieFragment
    private lateinit var typeRestFragment: TypeRestFragment
    private var mBinding: FragmentRankingBinding? = null
    private val binding get() = mBinding!!
    private val tabIcon = listOf(
        R.drawable.ic_baseline_format_list_bulleted_24,
        R.drawable.ic_baseline_map_24,
        R.drawable.ic_baseline_info_24,
    )

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : RankingFragment {
            return RankingFragment()
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        mBinding =  FragmentRankingBinding.inflate(layoutInflater)
//
//        Log.d(TAG, "RankingFragment - onCreate() called")
//
//
//        binding.viewpager.apply {
//            adapter = MyPagerAdapter(context as FragmentActivity)
//            setPageTransformer(ZoomOutPageTransformer())
//        }
//
//        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
//            tab.text = "Title $position"
//            tab.setIcon(tabIcon[position])
//        }.attach()
//
//
//    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.d(TAG, "RankingFragment - onAttach() called")
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "RankingFragment - onCreateView() called")
        mBinding = FragmentRankingBinding.inflate(inflater, container, false)

        binding.viewpager.apply {
            adapter = MyPagerAdapter(context as FragmentActivity)
            setPageTransformer(ZoomOutPageTransformer())
        }

        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = "Title $position"
            tab.setIcon(tabIcon[position])
        }.attach()
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}

