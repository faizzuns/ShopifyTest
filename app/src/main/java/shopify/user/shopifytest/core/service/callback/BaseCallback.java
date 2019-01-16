package shopify.user.shopifytest.core.service.callback;

import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shopify.user.shopifytest.core.base.BaseView;

public class BaseCallback<T, V extends BaseView> implements Callback<T> {
    private OnCallback<T> callback;
    private DisplayButtonOnCallback buttonOnCallback;
    private V view;
    private String type = null;

    public BaseCallback(OnCallback<T> callback) {
        this.callback = callback;
        type = "hidden";
    }

    public BaseCallback(OnCallback<T> callback, V view) {
        this.callback = callback;
        this.view = view;
        this.buttonOnCallback = null;
    }

    public BaseCallback(OnCallback<T> callback, DisplayButtonOnCallback buttonOnCallback, V view) {
        this.callback = callback;
        this.buttonOnCallback = buttonOnCallback;
        this.view = view;
        buttonOnCallback.hide();
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d("connection_response", "onResponse: " + response.toString());
        if (response.body() != null) {
            if (view != null || type.equals("hidden")) {
                callback.onSuccess(response.body());
            }
        }
        if (buttonOnCallback != null) buttonOnCallback.show();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (view != null) {
            view.displayMessage("Please check your internet connection.");
            callback.onFailed();
        }
        if (buttonOnCallback != null) buttonOnCallback.show();
    }
}
