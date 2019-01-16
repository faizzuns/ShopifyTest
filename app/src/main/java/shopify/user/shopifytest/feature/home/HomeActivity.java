package shopify.user.shopifytest.feature.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import butterknife.BindView;
import shopify.user.shopifytest.R;
import shopify.user.shopifytest.core.base.BaseActivity;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public class HomeActivity extends BaseActivity implements HomeListener.View, BaseLifecycle {

    HomeListener.Presenter presenter ;

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv_collection)
    RecyclerView rvCollection;
    @BindView(R.id.progress_collection)
    ProgressBar progressCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        render();
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
}
