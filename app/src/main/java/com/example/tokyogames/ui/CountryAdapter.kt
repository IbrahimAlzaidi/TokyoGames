package com.example.tokyogames.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tokyogames.R
import com.example.tokyogames.data.domain.Country
import com.example.tokyogames.databinding.ItemCountryBinding
import com.example.tokyogames.databinding.ItemHeaderBinding
import com.example.tokyogames.util.Constants

class CountryAdapter(private var list: List<Country>) : RecyclerView.Adapter<CountryAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType){
            Constants.ViewType.HEADER -> {
                val view =LayoutInflater.from(parent.context).inflate(R.layout.item_header,parent,false)
                return HeaderViewHolder(view)
            }
            Constants.ViewType.COMPONENT -> {
                val view =LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
                return CountryViewHolder(view)
            }
        }
           return super.createViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
     val currentCountry = list[position]
        when(holder){
            is CountryViewHolder ->{
                holder.binding.apply {
                    countryName.text = currentCountry.teamNoc
                    goldMedalNumber.text = currentCountry.goldMedal.toString()
                    silverMedalNumber.text = currentCountry.silverMedal.toString()
                    bronzeMedalNumber.text = currentCountry.bronzeMedal.toString()
                    rankNumber.text = currentCountry.rank.toString()
                    totalRankNumber.text = currentCountry.rankByTotal.toString()
                }
            }
            is HeaderViewHolder ->{
                holder.binding.headerTitle.text = "Tokyo Games Results"
            }
        }

    }

    fun setData(newList: List<Country>){
        val diffResult = DiffUtil.calculateDiff(CountryDiffUtil(list,newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount()= list.size

    override fun getItemViewType(position: Int): Int {
        return if(position == 0){
            Constants.ViewType.HEADER
        }else {
            Constants.ViewType.COMPONENT
        }
    }


    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class CountryViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemCountryBinding.bind(viewItem)
    }
    class HeaderViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemHeaderBinding.bind(viewItem)
    }
}