package shopify.user.shopifytest.feature.splashscreen;

import android.content.Context;
import android.os.Handler;

import shopify.user.shopifytest.core.Config;

class SplashscreenPresenter implements SplashscreenListener.Presenter {

    private SplashscreenListener.View view;
    private Runnable runnable;
    private Handler handler = new Handler();

    SplashscreenPresenter(SplashscreenListener.View view) {
        this.view = view;
    }

    @Override
    public void setImageTimeout() {
        view.setIconAnimation(Config.SPLASH_TIMEOUT);
        runnable = new Runnable() {
            @Override
            public void run() {
                boolean allowed = view.checkPermissions();
                if (allowed) {
                    view.navigateToHome();
                }
            }
        };
        handler.postDelayed(runnable, Config.SPLASH_TIMEOUT);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {


    }

    @Override
    public void onDestroy() {
        view = null;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
