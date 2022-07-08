package tech.ericwathome.moments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.ericwathome.moments.R
import tech.ericwathome.moments.network.ImageClient

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = this::class.simpleName
    }

    private val imageApi by lazy {
        ImageClient.imageApi
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkRequest()
    }

    private fun networkRequest() {
        val filter = HashMap<String, Int>()
        filter["page"] = 1
        filter["per_page"] = 20


        lifecycleScope.launch(Dispatchers.IO) {
            val response = imageApi.getAllPhotos(filter)
            if (response.isSuccessful) {
                Log.d(TAG, "networkRequest: ${response.body()}")
            }
        }
    }
}