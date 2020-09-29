package es.fgd192.lesson20

import es.fgd192.lesson20.model.CurrentWeather
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitBuilder.getService()
            ?.getWeather("Bishkek", getString(R.string.aip_keys))
            ?.enqueue(object : Callback<CurrentWeather> {
                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d("ghhhhhghhh","jjjjjjkjjjk")
                }

                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        var data = response.body()
                        TVWeather.text = data?.main?.temp.toString()
                    }
                }

            })
    }
}