package shopify.user.shopifytest.core.base;

import android.view.View;

public interface BaseFragmentView<P> extends BaseView{
    void attachPresenter(P presenter);

    void render(View view);
}
