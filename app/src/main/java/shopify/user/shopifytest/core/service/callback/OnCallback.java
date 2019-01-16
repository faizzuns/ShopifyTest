package shopify.user.shopifytest.core.service.callback;

public interface OnCallback<T> {
    void onSuccess(T data);
    void onFailed();
}
