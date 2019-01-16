package shopify.user.shopifytest.feature.detail;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import shopify.user.shopifytest.R;
import shopify.user.shopifytest.core.base.BaseActivity;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public class DetailActivity extends BaseActivity implements DetailListener.View, BaseLifecycle {

    DetailListener.Presenter presenter = new DetailPresenter(this);

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_description)
    TextView txtDescription;
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.rv_product)
    RecyclerView rvProduct;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        render();

        Intent intent = getIntent();
        Long id = intent.getLongExtra("collection_id",0);
        String title = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String url = intent.getStringExtra("url");

        showBasicCollectionInformation(title, desc, url);
        presenter.setContent(title, url);
        setUpList();

        swipeRefreshLayout.setRefreshing(true);
        presenter.searchProducts(id);
    }

    @Override
    public void render() {
        super.render();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.searchProducts(getIntent().getLongExtra("collection_id",0));
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
    public void showList() {
        rvProduct.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        rvProduct.setVisibility(View.GONE);

    }

    @Override
    public void setUpList() {
        rvProduct.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvProduct.setLayoutManager(llm);
        rvProduct.setAdapter(presenter.getProductAdapter());
    }

    @Override
    public void stopSwipeRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void scrollToTop() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_UP);
            }
        });
    }

    @Override
    public void showBasicCollectionInformation(String title, String desc, String url) {
        txtTitle.setText(title);
        txtDescription.setText(desc);
        Picasso.with(getApplicationContext()).load(url).into(imgIcon);
    }
}
