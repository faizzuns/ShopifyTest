package shopify.user.shopifytest.feature.detail;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import shopify.user.shopifytest.core.Config;
import shopify.user.shopifytest.core.model.collects.Collect;
import shopify.user.shopifytest.core.model.collects.Collects;
import shopify.user.shopifytest.core.model.product.Product;
import shopify.user.shopifytest.core.model.product.Products;
import shopify.user.shopifytest.core.service.callback.BaseCallback;
import shopify.user.shopifytest.core.service.callback.OnCallback;
import shopify.user.shopifytest.core.service.retrofit.RetrofitServices;

public class DetailPresenter implements DetailListener.Presenter {

    DetailListener.View view;
    ProductAdapter adapter;
    List<Product> list;

    public DetailPresenter(DetailListener.View view) {
        this.view = view;
        list = new ArrayList<>();
        adapter = new ProductAdapter(list, view);
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
    public void searchProducts(final Long id) {
        view.hideList();
        list = new ArrayList<>();
        Call<Collects> call = RetrofitServices.sendRequest().callCollects(id, Config.ACCESS_TOKEN);
        call.enqueue(new BaseCallback<>(new OnCallback<Collects>() {
            @Override
            public void onSuccess(Collects data) {
                if (data != null) {
                    String ids = "";
                    for (Collect collect : data.getCollects()) {
                        ids += collect.getProductId();
                        if (data.getCollects().indexOf(collect) != data.getCollects().size() - 1) ids += ",";
                    }
                    iterateResult(ids);
                }
            }

            @Override
            public void onFailed() {
                Log.d("DetailPresenterLogging", "onFailed: ");
                view.showList();
            }
        }));
    }

    @Override
    public void iterateResult(String ids) {
        if (ids.length() == 0) view.showList();
        else {
            Call<Products> call = RetrofitServices.sendRequest().callProducts(Config.ACCESS_TOKEN, ids);
            call.enqueue(new BaseCallback<>(new OnCallback<Products>() {
                @Override
                public void onSuccess(Products data) {
                    if (data != null) {
                        list.addAll(data.getProducts());
                        adapter.refreshData(list);
                        view.stopSwipeRefresh();
                    }
                    view.scrollToTop();
                    view.showList();
                }

                @Override
                public void onFailed() {
                    Log.d("DetailPresenterLogging", "onFailed: iterate");
                    view.showList();
                }
            }));
        }
    }

    @Override
    public void setContent(String title, String url) {
        adapter.setCollectionContent(title, url);
    }

    @Override
    public ProductAdapter getProductAdapter() {
        return adapter;
    }
}
