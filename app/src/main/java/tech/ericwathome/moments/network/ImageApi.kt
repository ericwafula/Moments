package tech.ericwathome.moments.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import tech.ericwathome.moments.model.Image

interface ImageApi {
    @GET("photos")
    suspend fun getAllPhotos(
        @QueryMap filter: HashMap<String, Int>
    ): Response<List<Image>>
}