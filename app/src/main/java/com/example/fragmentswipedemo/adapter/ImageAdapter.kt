package com.example.fragmentswipedemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentswipedemo.databinding.ItemImageBinding
import com.example.fragmentswipedemo.model.ImageModel

class ImageAdapter(mImageList: List<ImageModel>) :
    RecyclerView.Adapter<ImageAdapter.Holder>() {
    private var mImageList: List<ImageModel> = ArrayList()

    init {
        this.mImageList = mImageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.mBinding.ImgMain.setBackgroundResource(mImageList[holder.adapterPosition].images)
        holder.mBinding.TxtName.text = mImageList[holder.adapterPosition].name
    }

    override fun getItemCount(): Int {
        return mImageList.size
    }

    inner class Holder(var mBinding: ItemImageBinding) : RecyclerView.ViewHolder(
        mBinding.root
    )
}