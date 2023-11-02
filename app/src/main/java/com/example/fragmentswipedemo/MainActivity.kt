package com.example.fragmentswipedemo

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentswipedemo.Util.TabletTransformer
import com.example.fragmentswipedemo.databinding.ActivityMainBinding
import com.example.fragmentswipedemo.databinding.DialogTimeFinishBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import java.util.concurrent.TimeUnit

class MainActivity() : AppCompatActivity() {
    var mBinding: ActivityMainBinding? = null
    private var pageAdapter: MyTabPageAdapter? = null
    private var dialogTimeFinishBinding: DialogTimeFinishBinding? = null
    private var dialog: Dialog? = null
    var timeformat = "%02d:%02d"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(mBinding!!.root)
        pageAdapter = MyTabPageAdapter(supportFragmentManager)
        pageAdapter!!.addFragments(VideoFragment(), "Video")
        pageAdapter!!.addFragments(QuizFragment(), "Quiz")
        pageAdapter!!.addFragments(LinkFragment(), "Link")
        pageAdapter!!.addFragments(ImageFragment(), "Image")
        pageAdapter!!.addFragments(AudioFragment(), "Audio")
        mBinding!!.viewPager.adapter = pageAdapter
        mBinding!!.viewPager.setPageTransformer(true, TabletTransformer())
        mBinding!!.tabLayout.setupWithViewPager(mBinding!!.viewPager)
        mBinding!!.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabSelected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
        })
        object : CountDownTimer(600000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mBinding!!.TxtTimer.text = String.format(
                    timeformat,
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    ),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                    )
                )
            }

            override fun onFinish() {
                mBinding!!.TxtTimer.text = "00:00"
                showDialog()
            }
        }.start()
    }

    fun showDialog() {
        dialogTimeFinishBinding = DialogTimeFinishBinding.inflate(
            layoutInflater
        )
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(dialogTimeFinishBinding!!.root)
        dialog = builder.create()
        dialog!!.setCancelable(false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.show()
        dialogTimeFinishBinding!!.TxtDone.setOnClickListener(View.OnClickListener { dialog!!.dismiss() })
    }
}