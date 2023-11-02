package com.example.fragmentswipedemo

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentswipedemo.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private var mBinding: FragmentVideoBinding? = null
    private var videoPlay = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentVideoBinding.inflate(inflater, container, false)
        mBinding!!.VideoView.setVideoURI(
            Uri.parse(
                "android.resource://" + requireContext().packageName + "/" +
                        R.raw.video1
            )
        )
        mBinding!!.VideoView.start()
        mBinding!!.VideoView.setOnCompletionListener { mp -> mp.start() }
        mBinding!!.clNext.setOnClickListener {
            if (mBinding!!.VideoView.isPlaying) {
                mBinding!!.VideoView.pause()
                mBinding!!.VideoView.stopPlayback()
            }
            if (videoPlay == 1) {
                videoPlay = 2
                mBinding!!.VideoView.setVideoURI(
                    Uri.parse(
                        "android.resource://" + requireContext().packageName + "/" +
                                R.raw.video2
                    )
                )
                mBinding!!.VideoView.start()
            } else if (videoPlay == 2) {
                videoPlay = 1
                mBinding!!.VideoView.setVideoURI(
                    Uri.parse(
                        "android.resource://" + requireContext().packageName + "/" +
                                R.raw.video1
                    )
                )
                mBinding!!.VideoView.start()
            }
            mBinding!!.VideoView.setOnCompletionListener { mp -> mp.start() }
        }
        return mBinding!!.root
    }
}