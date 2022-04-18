package com.example.sc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sc.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var socialFragment: SocialFragment

    companion object {
        const val TAG : String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called ")

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavigationItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()

    }

    private val onBottomNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈버튼 클릭")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹버튼 클릭")
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필버튼 클릭")
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()

            }

            R.id.menu_social -> {
                Log.d(TAG, "MainActivity - 소셜버튼 클릭")
                socialFragment = SocialFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, socialFragment).commit()
            }
        }
            true
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationItemSelected() called ")
//
//        when(item.itemId){
//            R.id.menu_home -> {
//                Log.d(TAG, "MainActivity - 홈버튼 클릭")
//            }
//            R.id.menu_ranking -> {
//                Log.d(TAG, "MainActivity - 랭킹버튼 클릭")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필버튼 클릭")
//            }
//
//            R.id.menu_social -> {
//                Log.d(TAG, "MainActivity - 소셜버튼 클릭")
//            }
//        }
//
//        return true
//    }
}