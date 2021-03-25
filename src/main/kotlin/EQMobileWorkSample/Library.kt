package EQMobileWorkSample

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

public data class LocationEvent(val lat: Float, val lon: Float, val time: Long, val ext: String)

public class Library {

    fun setup(): Boolean {
        return true
    }

    /**
     * To log the user location with given params
     */
    suspend fun log(event: LocationEvent) = coroutineScope{

        val time : Long
        var lat = 0.0f
        var lon = 0.0f
        if(event.time == null){
            time = getCurrentTimestamp()
        }else{
            time = event.time
        }

        if(event.lat > -90 && event.lat < 90){
            lat = event.lat;
        }

        if(event.lon > -180 && event.lon < 180){
            lon = event.lon;
        }

        val latLongModel =  LatLongModel()
        latLongModel.lat = lat
        latLongModel.long = lon
        latLongModel.time = time
        // POST to API Server
        launch {
            reqUrl(latLongModel)
        }
    }

    /**
     * To request the desired url with params
     */
    private suspend fun reqUrl(latlongModel: LatLongModel) {

            try {
                val response = ApiAdapter.apiClient.postLog(latlongModel)
                // Check if response was successful
                if (response.isSuccessful && response.body() != null) {
                    // Retrieve data.
                    val data = response.body()!!
                    print("Data=>$data")
                } else {
                    /**
                     * Show API error.
                     * This is when the server responded with an error.
                     */
                    print("Server Error=>$response")
                }
            } catch (e: Exception) {

                /**
                 * Show API error. This is the error raised by the client.
                 * The API probably wasn't called in this case, so better check before assuming.
                 */
                print("Exception=>$e")
            }
        }

    }

    /**
     * To get the current timestamp
     * @return current timestamp
     */
    private fun getCurrentTimestamp(): Long{
        val calendar = Calendar.getInstance()
        println(calendar.timeInMillis)
        return System.currentTimeMillis()
    }

