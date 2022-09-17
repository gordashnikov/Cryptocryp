package com.rustyrobot.cryptocryp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rustyrobot.cryptocryp.databinding.ItemCoinInfoBinding
import com.rustyrobot.cryptocryp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CoinInfoViewHolder(
        ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {

        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                tvSymbols.text = fromSymbol + " / " + toSymbol
                tvPrice.text = price
                tvLastUpdate.text = getFormattedTime()
                Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
            }
        }


    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(private val binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val ivLogoCoin = binding.ivLogoCoin
        val tvSymbols = binding.tvSymbols
        val tvPrice = binding.tvPrice
        val tvLastUpdate = binding.tvLastUpdate

    }
}