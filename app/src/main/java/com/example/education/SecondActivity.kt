package com.example.education

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder



class SecondActivity : AppCompatActivity() {

    companion object{
        private const val SEARCH_DELIMITER = "/search/"
    }

    private val googleSearchTextView by lazy { findViewById<TextView>(R.id.text_view_google_search) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        intent.data?.path?.let {
            val searchRequest: String = it.substringAfter(SEARCH_DELIMITER)
            googleSearchTextView.text = searchRequest
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("QQQ","OnNew Intent");
    }
}
