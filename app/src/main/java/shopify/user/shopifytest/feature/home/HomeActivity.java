package shopify.user.shopifytest.feature.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import shopify.user.shopifytest.R;
import shopify.user.shopifytest.core.base.BaseActivity;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public class HomeActivity extends BaseActivity implements HomeListener.View, BaseLifecycle {

    HomeListener.Presenter presenter = new HomePresenter(this);

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv_collection)
    RecyclerView rvCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        render();
        setUpList();
        swipeRefreshLayout.setRefreshing(true);
        Log.d("HomePresenterLogging", "onCreate: ");
        presenter.search();
    }

    @Override
    public void render() {
        super.render();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.search();
            }
        });
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        presenter.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void stopSwipeRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showList() {
        rvCollection.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        rvCollection.setVisibility(View.GONE);
    }

    @Override
    public void setUpList() {
        rvCollection.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvCollection.setLayoutManager(llm);
        rvCollection.setAdapter(presenter.getCollectionAdapter());
    }
}
