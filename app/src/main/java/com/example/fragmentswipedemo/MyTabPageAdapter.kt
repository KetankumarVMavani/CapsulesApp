package com.example.fragmentswipedemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyTabPageAdapter(fragmentManager: FragmentManager?) : FragmentPagerAdapter(
    fragmentManager!!
) {
    private var fragmentTitleList: ArrayList<String> = ArrayList()
    private var fragmentsList: ArrayList<Fragment> = ArrayList()

    override fun getItemPosition(obj: Any): Int {
        return -2
    }

    override fun getItem(i: Int): Fragment {
        return fragmentsList[i]
    }

    override fun getCount(): Int {
        return fragmentTitleList.size
    }

    fun addFragments(fragment: Fragment, str: String) {
        fragmentsList.add(fragment)
        fragmentTitleList.add(str)
    }

    override fun getPageTitle(i: Int): CharSequence? {
        return fragmentTitleList[i]
    }
}