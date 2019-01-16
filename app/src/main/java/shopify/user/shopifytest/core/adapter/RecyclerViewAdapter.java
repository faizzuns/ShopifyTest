package shopify.user.shopifytest.core.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import shopify.user.shopifytest.core.base.BaseView;


public abstract class RecyclerViewAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected List<T> list;
    protected BaseView baseView;

    protected RecyclerViewAdapter(List<T> list, BaseView baseView) {
        this.list = list;
        this.baseView = baseView;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(List<T> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
