package es.fgd192.lesson20

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var service: WeatherApi? = null
    fun getService():WeatherApi?{
        if (service == null)
            service = buildRetrofit()

        return service
    }
    private fun buildRetrofit(): WeatherApi {

        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}//   https://api.openweathermap.org/data/2.5/weather?q=Bishkek&appid=5e57e6677105653aa7c3c5b666097751