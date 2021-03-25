package EQMobileWorkSample

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *
 * An interface to used as the Retrofit service
 * Holds all APIs
 *
 * */

interface ApiClient {

    @POST("/post")
    suspend fun postLog(@Body latLongModel: LatLongModel): Response<String>
}