package com.rustyrobot.cryptocryp.api

import com.rustyrobot.cryptocryp.pojo.CoinInfoListOfData
import com.rustyrobot.cryptocryp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "6726c10ca8b0edb7eff531f1dbd9aa78bd81a1112dd3751f2fa99173be54c6d7",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "6726c10ca8b0edb7eff531f1dbd9aa78bd81a1112dd3751f2fa99173be54c6d7",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
    ): Single<CoinPriceInfoRawData>

    companion object {
        const val QUERY_PARAM_LIMIT = "limit"
        const val QUERY_PARAM_TO_SYMBOL = "tsym"
        const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        const val QUERY_PARAM_API_KEY = "api_key"
        const val CURRENCY = "USD"
    }
}