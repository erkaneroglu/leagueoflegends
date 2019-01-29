package erkaneroglu.com.lolguide;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.irozon.sneaker.Sneaker;

import java.util.ArrayList;
import java.util.List;

import erkaneroglu.com.lolguide.Adapters.HeroAdapter;
import erkaneroglu.com.lolguide.Modals.Hero;
import erkaneroglu.com.lolguide.RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Hero> list;
    RecyclerView recyclerView;
    HeroAdapter championsAdapter;
    Sneaker sneaker;
    ShimmerFrameLayout shimmerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlElements();
        GetDatasFromJson();
        CheckInternetConnection();
    }

    @Override
    protected void onStop() {
        shimmerLayout.stopShimmer();
        super.onStop();
    }

    public void XmlElements() {
        recyclerView = findViewById(R.id.recycler_view_id);
        shimmerLayout = findViewById(R.id.shimmerLayout);
    }

    public boolean isConnect() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void CheckInternetConnection() {
        if (isConnect()) {
            GetDatasFromJson();
        } else {
            GetSneaker();
        }

    }

    public void GetSneaker() {
        String fontName="armata.ttf";
        sneaker.with(this)
                .setMessage("Uygulama içerisinde bulunan verilerin görüntülenebilmesi için internet bağlantısı gerekmektedir.Lütfen bağlantınızı kontrol ediniz.")
                .autoHide(false)
                .setHeight(100)
                .sneakWarning();
    }

    public void GetDatasFromJson() {
        list = new ArrayList<>();
        final Call<List<Hero>> listCall = ManagerAll.getInstanse().getirBilgi();
        listCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    championsAdapter = new HeroAdapter(getApplicationContext(), list);
                    shimmerLayout.stopShimmer();
                    shimmerLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(championsAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_search);
        MenuItem menuItem1 = menu.findItem(R.id.action_reflesh);
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (isConnect()) {
                    GetDatasFromJson();
                } else {
                    GetSneaker();
                }
                return false;
            }
        });

        final SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                menuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                try {
                    final List<Hero> filteredmodellist = filter(list, s);
                    championsAdapter.updateList(filteredmodellist);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
        return true;
    }

    private List<Hero> filter(List<Hero> pl, String query) {
        query = query.toLowerCase();
        final List<Hero> filteredModeList = new ArrayList<>();
        for (Hero model : pl) {
            final String text = model.getHeroName().toLowerCase();
            if (text.startsWith(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }
}
