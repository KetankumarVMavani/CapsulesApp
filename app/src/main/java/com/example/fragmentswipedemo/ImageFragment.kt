package com.example.fragmentswipedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentswipedemo.Util.Utils
import com.example.fragmentswipedemo.adapter.ImageAdapter
import com.example.fragmentswipedemo.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private var mBinding: FragmentImageBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentImageBinding.inflate(inflater, container, false)

        mBinding!!.RvImages.adapter = ImageAdapter(Utils.imageList)

        return mBinding!!.root
    }
}