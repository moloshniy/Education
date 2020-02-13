package com.example.education
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder

class DeepLinkDispatcherActivity : AppCompatActivity() {
    companion object {
        private const val GOOGLE_SEARCH_REQUEST: String = "google.com/search/"
    }

    override fun onResume() {
        super.onResume()

        intent.data?.let {
            when (true) {
                GOOGLE_SEARCH_REQUEST in it.schemeSpecificPart ->
                    moveToFourthActivity(it.schemeSpecificPart.substringAfter(GOOGLE_SEARCH_REQUEST))
            }
        }
    }

    private fun moveToFourthActivity(incomingRequest: String) {
        val intent = Intent(this, FourthActivity::class.java)
        intent.putExtra(FourthActivity.INTENT_INCOMING_REQUEST_KEY, incomingRequest)

        val taskStackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntentWithParentStack(intent)
        taskStackBuilder.startActivities()
    }
}
