package tech.ericwathome.moments.repository

import android.util.Log
import tech.ericwathome.moments.model.Image
import tech.ericwathome.moments.network.ImageClient

object Repository {
    private val TAG = this::class.simpleName

    private var imageApi = ImageClient.imageApi

    suspend fun getAllPhotos(): List<Image> {
        var data = listOf<Image>()
        val filter = HashMap<String, Int>()
        filter["page"] = 1
        filter["per_page"] = 20

        val response = imageApi.getAllPhotos(filter)
        if (response.isSuccessful) {
            response.body()?.let {
                data = it
            }
        } else {
            Log.d(TAG, "getAllPhotos Error: ${response.errorBody()}")
        }

        return data
    }
}