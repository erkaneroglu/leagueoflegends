package erkaneroglu.com.lolguide.RestApi;

import java.util.List;

import erkaneroglu.com.lolguide.Modals.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("lolguide")
    Call<List<Hero>> getir();
}