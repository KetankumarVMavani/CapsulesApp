package com.example.fragmentswipedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentswipedemo.Util.Utils
import com.example.fragmentswipedemo.adapter.ImageAdapter
import com.example.fragmentswipedemo.adapter.LinkAdapter
import com.example.fragmentswipedemo.databinding.FragmentLinkBinding

class LinkFragment : Fragment() {
    private var mBinding: FragmentLinkBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLinkBinding.inflate(inflater, container, false)
        mBinding!!.RvLink.adapter = LinkAdapter(Utils.linkList)
        return mBinding!!.root
    }
}