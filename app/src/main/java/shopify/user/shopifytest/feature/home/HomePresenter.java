package shopify.user.shopifytest.feature.home;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import shopify.user.shopifytest.core.Config;
import shopify.user.shopifytest.core.model.collections.CustomCollection;
import shopify.user.shopifytest.core.model.collections.CustomCollections;
import shopify.user.shopifytest.core.service.callback.BaseCallback;
import shopify.user.shopifytest.core.service.callback.OnCallback;
import shopify.user.shopifytest.core.service.retrofit.RetrofitServices;

public class HomePresenter implements HomeListener.Presenter {

    private HomeListener.View view;
    private List<CustomCollection> list;
    private CollectionAdapter adapter;

    public HomePresenter(HomeListener.View view) {
        this.view = view;
        list = new ArrayList<>();
        adapter = new CollectionAdapter(list, view);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void search() {
        view.hideList();
        list = new ArrayList<>();
        Call<CustomCollections> call = RetrofitServices.sendRequest().callCollections(Config.ACCESS_TOKEN);
        call.enqueue(new BaseCallback<>(new OnCallback<CustomCollections>() {
            @Override
            public void onSuccess(CustomCollections data) {
                if (view == null) return;
                view.showList();
                if (data != null) {
                    list.addAll(data.getCustomCollections());
                    adapter.refreshData(list);
                    view.stopSwipeRefresh();
                }
            }

            @Override
            public void onFailed() {
                view.showList();
                Log.d("HomePresenterLogging", "onFailed: Fail");
            }
        }));
    }

    @Override
    public CollectionAdapter getCollectionAdapter() {
        return adapter;
    }
}
