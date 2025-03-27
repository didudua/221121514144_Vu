package due.giuaky221121514144.ui.Day3_Network.network;

import java.util.List;

import due.giuaky221121514144.ui.Day3_Network.model.Item;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API250_movies {
    String SERVER_URL = "https://imdb236.p.rapidapi.com";
    API250_movies apiService = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API250_movies.class);
    @Headers({
            "x-rapidapi-host:imdb236.p.rapidapi.com",
            "x-rapidapi-key:c3bf9eb878msh251d2dcbc7c7e79p1c311djsn51c6f9ec71a8"
    })


    @GET("/imdb/lowest-rated-movies")
    Call<List<Item>> getListData();
}
