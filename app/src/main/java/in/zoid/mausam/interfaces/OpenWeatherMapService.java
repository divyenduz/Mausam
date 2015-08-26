package in.zoid.mausam.interfaces;

import in.zoid.mausam.activities.BaseActivity;
import in.zoid.mausam.pojo.WeatherDataComplex;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by divyendusingh on 8/2/15.
 */
public interface OpenWeatherMapService {
    @GET("/data/2.5/forecast/daily?mode=json&units=metric&cnt=7&APPID=" + BaseActivity.API_KEY)
    void getWeatherDataByCityName(@Query("lat") String lat, @Query("lon") String lon, Callback<WeatherDataComplex> data);
}
