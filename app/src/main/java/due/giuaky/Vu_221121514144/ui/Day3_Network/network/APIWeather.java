package due.giuaky.Vu_221121514144.ui.Day3_Network.network;

import java.util.List;

import due.giuaky.Vu_221121514144.ui.Day3_Network.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIWeather {
    public static String BASE_URL = "https://dataservice.accuweather.com";
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}
