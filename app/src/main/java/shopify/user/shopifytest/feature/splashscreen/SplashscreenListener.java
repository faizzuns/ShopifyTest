package shopify.user.shopifytest.feature.splashscreen;

import android.content.Context;

import shopify.user.shopifytest.core.base.BaseActivityView;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public interface SplashscreenListener {
    interface View extends BaseActivityView {
        void setIconAnimation(long duration);
        void navigateToHome();
    }

    interface Presenter extends BaseLifecycle {
        void setImageTimeout();
    }
}
