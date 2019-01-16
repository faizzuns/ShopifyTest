package shopify.user.shopifytest.feature.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shopify.user.shopifytest.R;
import shopify.user.shopifytest.core.adapter.RecyclerViewAdapter;
import shopify.user.shopifytest.core.base.BaseView;
import shopify.user.shopifytest.core.model.product.Product;
import shopify.user.shopifytest.core.model.product.Variant;

public class ProductAdapter extends RecyclerViewAdapter<Product, ProductAdapter.ViewHolder> {

    private String title = "";
    private String url = "";

    protected ProductAdapter(List<Product> list, BaseView baseView) {
        super(list, baseView);
    }

    public void setCollectionContent(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_products,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Product product = list.get(i);
        viewHolder.txtTitle.setText(title);
        viewHolder.txtProductName.setText(product.getTitle());
        Picasso.with(baseView.getApplicationContext()).load(url).into(viewHolder.iconCollection);

        int count = 0;
        for (Variant variant : product.getVariants()) {
            count += variant.getInventoryQuantity();
        }
        viewHolder.txtCount.setText(String.valueOf(count));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_collection)
        ImageView iconCollection;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_product_name)
        TextView txtProductName;
        @BindView(R.id.txt_count)
        TextView txtCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
