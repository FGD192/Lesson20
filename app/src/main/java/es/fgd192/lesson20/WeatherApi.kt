package es.fgd192.lesson20

import es.fgd192.lesson20.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
@GET("data/2.5/weather")
fun getWeather(@Query("q")city: String, @Query("appid")appId: String) : Call<CurrentWeather>
}