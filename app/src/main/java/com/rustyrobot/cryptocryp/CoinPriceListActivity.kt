package com.rustyrobot.cryptocryp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rustyrobot.cryptocryp.adapters.CoinInfoAdapter
import com.rustyrobot.cryptocryp.databinding.ActivityCoinPriceListBinding


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinPriceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter()
        binding.rvCoinPriceList.adapter = adapter

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it

        })



    }


}