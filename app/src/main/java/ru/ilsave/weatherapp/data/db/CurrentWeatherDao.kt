package ru.ilsave.weatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ilsave.weatherapp.data.db.entity.CURRENT_ID
import ru.ilsave.weatherapp.data.db.entity.Data

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntity: Data)

    @Query("select * from current_weather where id = $CURRENT_ID")
    fun getWeather(): LiveData<Data>
}