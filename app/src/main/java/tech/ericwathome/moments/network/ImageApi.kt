package tech.ericwathome.moments.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query
import tech.ericwathome.moments.model.Photo

interface ImageApi {
    @GET("photos")
    suspend fun getAllPhotos(
        @Query("page") page: Int
    ): Flow<List<Photo>>
}