package ru.ilsave.weatherapp.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.ilsave.weatherapp.R
import ru.ilsave.weatherapp.data.RetrofitInstance

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getCurrentWeatherApiService("London")
            if (response.isSuccessful) {
                tv_current.text =
                    RetrofitInstance.api.getCurrentWeatherApiService("London").toString()
                Log.d(
                    "Current fragment",
                    response.body().toString()
                )
//                RetrofitInstance.api.getCurrentWeatherApiService("London").enqueue(object : retrofit2.Callback<CurrentWeatherResponse>{
//                    override fun onResponse(
//                        call: Call<CurrentWeatherResponse>,
//                        response: Response<CurrentWeatherResponse>
//                    ) {
//
//                        Log.d("Current Fragment", response.body().toString())
//                        tv_current.text = response.body().toString()
//                    }
//
//                    override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
//                        Log.d("Current Fragment", "failer")
//
//                    }
//                }).toString())
            }
        }
    }

}