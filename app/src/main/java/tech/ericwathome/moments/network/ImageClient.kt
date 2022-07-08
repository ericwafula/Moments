package tech.ericwathome.moments.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.ericwathome.moments.utils.Constants

object ImageClient {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val auth = Interceptor { chain ->
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Client-ID ${Constants.ACCESS_KEY}")
            .build()
        chain.proceed(request)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(auth)
        .addInterceptor(logger)

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val imageApi: ImageApi = retrofit.create(ImageApi::class.java)

}