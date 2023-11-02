package com.example.fragmentswipedemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentswipedemo.databinding.ItemImageBinding
import com.example.fragmentswipedemo.databinding.ItemLinkBinding
import com.example.fragmentswipedemo.model.ImageModel

class LinkAdapter(mImageList: List<String>) :
    RecyclerView.Adapter<LinkAdapter.Holder>() {
    private var mImageList: List<String> = ArrayList()

    init {
        this.mImageList = mImageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemLinkBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.mBinding.tvLink1.text = mImageList[holder.adapterPosition]
    }

    override fun getItemCount(): Int {
        return mImageList.size
    }

    inner class Holder(var mBinding: ItemLinkBinding) : RecyclerView.ViewHolder(
        mBinding.root
    )
}