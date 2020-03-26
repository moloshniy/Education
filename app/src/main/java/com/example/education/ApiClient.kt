package com.example.education


import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search/item")
    fun sentRequest(@Query("upc") upc:String): Call<ResponseBody>
}