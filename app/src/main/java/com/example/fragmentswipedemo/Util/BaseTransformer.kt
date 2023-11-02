package com.example.fragmentswipedemo.Util

import android.view.View
import androidx.viewpager.widget.ViewPager

abstract class BaseTransformer : ViewPager.PageTransformer {
    protected abstract fun onTransform(view: View?, position: Float)
    override fun transformPage(view: View, position: Float) {
        onPreTransform(view, position)
        onTransform(view, position)
        onPostTransform(view, position)
    }

    protected fun hideOffscreenPages(): Boolean {
        return true
    }

    protected val isPagingEnabled: Boolean
        protected get() = false

    protected fun onPreTransform(view: View, position: Float) {
        val width = view.width.toFloat()
        view.rotationX = 0f
        view.rotationY = 0f
        view.rotation = 0f
        view.scaleX = 1f
        view.scaleY = 1f
        view.pivotX = 0f
        view.pivotY = 0f
        view.translationY = 0f
        view.translationX = if (isPagingEnabled) 0f else -width * position
        if (hideOffscreenPages()) {
            view.alpha = if (position <= -1f || position >= 1f) 0f else 1f
        } else {
            view.alpha = 1f
        }
    }

    protected fun onPostTransform(view: View?, position: Float) {}
}