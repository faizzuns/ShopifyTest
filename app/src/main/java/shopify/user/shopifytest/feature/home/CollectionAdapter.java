package shopify.user.shopifytest.feature.home;

import android.content.Intent;
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
import shopify.user.shopifytest.core.model.collections.CustomCollection;
import shopify.user.shopifytest.feature.detail.DetailActivity;

public class CollectionAdapter extends RecyclerViewAdapter<CustomCollection, CollectionAdapter.ViewHolder> {
    protected CollectionAdapter(List<CustomCollection> list, BaseView baseView) {
        super(list, baseView);
    }

    @NonNull
    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_collections,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionAdapter.ViewHolder viewHolder, final int i) {
        final CustomCollection customCollection = list.get(i);

        viewHolder.txtName.setText(customCollection.getTitle());
        viewHolder.txtDescription.setText(customCollection.getBodyHtml());
        Picasso.with(baseView.getApplicationContext()).load(customCollection.getImage().getSrc()).into(viewHolder.iconCollection);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(baseView.getApplicationContext(), DetailActivity.class);
                intent.putExtra("collection_id", customCollection.getId());
                baseView.goToActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon_collection)
        ImageView iconCollection;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.txt_description)
        TextView txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
