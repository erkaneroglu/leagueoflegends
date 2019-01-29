package erkaneroglu.com.lolguide.RestApi;

import java.util.List;

import erkaneroglu.com.lolguide.Modals.Hero;
import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourGetInstanse = new ManagerAll();

    public static synchronized ManagerAll getInstanse() {
        return ourGetInstanse;
    }

    public Call<List<Hero>> getirBilgi() {
        Call<List<Hero>> x = getRestApiClient().getir();
        return x;
    }
}

