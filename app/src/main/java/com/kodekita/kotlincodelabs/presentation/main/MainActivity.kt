package com.kodekita.kotlincodelabs.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kodekita.kotlincodelabs.R
import com.kodekita.kotlincodelabs.R.layout
import com.kodekita.kotlincodelabs.presentation.account.AccountFragment
import com.kodekita.kotlincodelabs.presentation.home.HomeFragment
import com.kodekita.kotlincodelabs.presentation.search.SearchFragment
import com.kodekita.kotlincodelabs.utils.AppConstants
import kotlinx.android.synthetic.main.activity_main.bnvMain

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val accountFragment = AccountFragment()
    private var active: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        bnvMain.selectedItemId = R.id.action_home

        supportFragmentManager.beginTransaction().apply {
            add(R.id.mainContainer, searchFragment, AppConstants.SEARCH).hide(searchFragment)
            add(R.id.mainContainer, accountFragment, AppConstants.ACCOUNT).hide(accountFragment)
            add(R.id.mainContainer, homeFragment, AppConstants.HOME)
            commit()
        }

        bnvMain.setOnNavigationItemSelectedListener {
            if (bnvMain.selectedItemId != it.itemId) {
                when (it.itemId) {
                    R.id.action_home -> {
                        supportFragmentManager.beginTransaction().hide(active).show(homeFragment).commit()
                        active = homeFragment
                        Log.d("Fragment", "HOME")
                    }
                    R.id.action_search -> {
                        supportFragmentManager.beginTransaction().hide(active).show(searchFragment).commit()
                        active = searchFragment
                        Log.d("Fragment", "Search")
                    }
                    R.id.action_account -> {
                        supportFragmentManager.beginTransaction().hide(active).show(accountFragment).commit()
                        active = accountFragment
                        Log.d("Fragment", "Account")
                    }
                }
            }
            true
        }
    }
}