package com.example.education
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FourthActivity : AppCompatActivity() {

    companion object {
        const val INTENT_INCOMING_REQUEST_KEY = "INTENT_INCOMING_REQUEST_KEY"
    }

    private val googleSearchTextView by lazy { findViewById<TextView>(R.id.text_view_google_search) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
    }

    override fun onResume() {
        super.onResume()
        googleSearchTextView.text = intent.getStringExtra(INTENT_INCOMING_REQUEST_KEY)
    }
}
