package com.example.tokyogames.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.tokyogames.data.domain.Country

class CountryDiffUtil(private val mOldList: List<Country>, private val mNewList: List<Country>): DiffUtil.Callback() {
    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldList[oldItemPosition].rank == mNewList[newItemPosition].rank
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}