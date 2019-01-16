package shopify.user.shopifytest.feature.splashscreen;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import shopify.user.shopifytest.R;
import shopify.user.shopifytest.core.base.BaseActivity;
import shopify.user.shopifytest.core.base.BaseLifecycle;
import shopify.user.shopifytest.feature.home.HomeActivity;

public class SplashscreenActivity extends BaseActivity implements SplashscreenListener.View, BaseLifecycle {

    SplashscreenListener.Presenter presenter = new SplashscreenPresenter(this);

    @BindView(R.id.frame_icon) LinearLayout frameIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        render();
        presenter.setImageTimeout();
    }


    @Override
    public void setIconAnimation(long duration) {
        frameIcon.animate().alpha(0f).setDuration(duration);
        frameIcon.animate().scaleXBy(0.5f).setDuration(duration);
        frameIcon.animate().scaleYBy(0.5f).setDuration(duration);
    }

    @Override
    public void navigateToHome() {
        goToActivity(HomeActivity.class, true);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            boolean allowed = checkPermissions();
            if (allowed) navigateToHome();
        } else {
            Toast.makeText(this, "You must allow all permission", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
