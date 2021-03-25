package EQMobileWorkSample

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * This static class holds all settings for Retrofit.
 **/

object ApiAdapter {
    // Interface to be used as Retrofit service.
    val apiClient: ApiClient = Retrofit.Builder()
            .baseUrl("https://httpbin.org/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
}