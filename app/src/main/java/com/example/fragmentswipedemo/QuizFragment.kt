package com.example.fragmentswipedemo

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentswipedemo.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    private var mBinding: FragmentQuizBinding? = null
    private var questionNumber = 1
    private var answer = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentQuizBinding.inflate(inflater, container, false)


        val colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_enabled),
                intArrayOf(android.R.attr.state_enabled)
            ), context?.let {
                intArrayOf(
                    requireContext().getColor(R.color.appcolor),
                    requireContext().getColor(R.color.appcolor)
                )
            }
        )

        mBinding!!.RbOption1.buttonTintList = colorStateList
        mBinding!!.RbOption2.buttonTintList = colorStateList
        mBinding!!.RbOption3.buttonTintList = colorStateList
        mBinding!!.RbOption4.buttonTintList = colorStateList

        mBinding!!.RbOption1.isClickable = false
        mBinding!!.RbOption2.isClickable = false
        mBinding!!.RbOption3.isClickable = false
        mBinding!!.RbOption4.isClickable = false
        mBinding!!.MainOption1.setOnClickListener { checked(mBinding!!.RbOption1) }
        mBinding!!.MainOption2.setOnClickListener { checked(mBinding!!.RbOption2) }
        mBinding!!.MainOption3.setOnClickListener { checked(mBinding!!.RbOption3) }
        mBinding!!.MainOption4.setOnClickListener { checked(mBinding!!.RbOption4) }
        mBinding!!.TxtNext.setOnClickListener {
            if (mBinding!!.RbOption1.isChecked || mBinding!!.RbOption2.isChecked || mBinding!!.RbOption3.isChecked || mBinding!!.RbOption4.isChecked) {
                if (questionNumber == 1) {
                    questionNumber = 2
                    mBinding!!.TxtCorrectAnswer.text = ""
                    if (mBinding!!.RbOption1.isChecked) {
                        answer++
                    }
                    mBinding!!.tvTotalQuestions.text = "Questions 2/2"
                    mBinding!!.RbOption1.isChecked = false
                    mBinding!!.RbOption2.isChecked = false
                    mBinding!!.RbOption3.isChecked = false
                    mBinding!!.RbOption4.isChecked = false
                    mBinding!!.TxtQuestion.setText(R.string.question2)
                    mBinding!!.TxtOption1.setText(R.string.question2option1)
                    mBinding!!.TxtOption2.setText(R.string.question2option2)
                    mBinding!!.TxtOption3.setText(R.string.question2option3)
                    mBinding!!.TxtOption4.setText(R.string.question2option4)
                } else {
                    mBinding!!.TxtCorrectAnswer.text = ""
                    if (mBinding!!.RbOption1.isChecked) {
                        answer++
                    }
                    mBinding!!.RbOption1.isChecked = false
                    mBinding!!.RbOption2.isChecked = false
                    mBinding!!.RbOption3.isChecked = false
                    mBinding!!.RbOption4.isChecked = false
                    mBinding!!.TxtScroll.text = "Correct : $answer"
                }
            } else {
                Toast.makeText(context, "Select at least One Option", Toast.LENGTH_SHORT).show()
            }
        }

        mBinding!!.LayoutCheckAnswer.setOnClickListener {
            if (questionNumber == 1) {
                mBinding!!.TxtCorrectAnswer.text =
                    "Correct Answer : " + getString(R.string.question1option1)
            } else {
                mBinding!!.TxtCorrectAnswer.text =
                    "Correct Answer : " + getString(R.string.question2option1)
            }
        }

        return mBinding!!.root
    }

    fun checked(radioButton: RadioButton) {
        mBinding!!.RbOption1.isChecked = false
        mBinding!!.RbOption2.isChecked = false
        mBinding!!.RbOption3.isChecked = false
        mBinding!!.RbOption4.isChecked = false
        radioButton.isChecked = true
    }
}