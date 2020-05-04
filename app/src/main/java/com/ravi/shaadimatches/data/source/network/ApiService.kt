package com.ravi.shaadimatches.data.source.network

import com.ravi.shaadimatches.data.model.ShaadiMatchesResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    fun getMatchesList(@Query("results") results: String?): Single<ShaadiMatchesResponseModel>
}