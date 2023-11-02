package com.example.fragmentswipedemo.Util

import com.example.fragmentswipedemo.R
import com.example.fragmentswipedemo.model.ImageModel

object Utils {
    val imageList: List<ImageModel>
        get() {
            val imageModels: MutableList<ImageModel> = ArrayList()
            imageModels.add(ImageModel(R.drawable.image3, "Image 1"))
            imageModels.add(ImageModel(R.drawable.image4, "Image 2"))
            imageModels.add(ImageModel(R.drawable.image5, "Image 3"))
            imageModels.add(ImageModel(R.drawable.image6, "Image 4"))
            imageModels.add(ImageModel(R.drawable.image7, "Image 5"))
            imageModels.add(ImageModel(R.drawable.image8, "Image 6"))
            return imageModels
        }
    val linkList: List<String>
        get() {
            val linkList: MutableList<String> = ArrayList()
            linkList.add("https://www.google.com")
            linkList.add("https://www.geeksforgeeks.org")
            linkList.add("https://developer.android.com")
            linkList.add("https://www.w3schools.com")
            linkList.add("https://www.javatpoint.com")
            return linkList
        }
}