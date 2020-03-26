package com.example.education

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofitBuilder = Retrofit.Builder().baseUrl("http://mysite.com")
        val rt = retrofitBuilder.build()
        val ss = rt.create(ApiClient::class.java)
        ss.sentRequest("3232")
    }
}

