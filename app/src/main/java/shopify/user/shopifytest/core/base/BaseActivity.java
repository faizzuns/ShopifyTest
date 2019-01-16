package shopify.user.shopifytest.core.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import butterknife.ButterKnife;
import shopify.user.shopifytest.core.Config;

/**
 * @author Ahmad Faiz Sahupala
 * Derrived Activity must call render function after set layout content
 * Derrived ACtivity must override onDestroy Method and call onDestroy in it Presenter
 */
public class BaseActivity extends AppCompatActivity implements BaseActivityView {

    @Override
    public void goToActivity(Class<?> destinationClass) {
        goToActivity(destinationClass, false, false);
    }

    @Override
    public void goToActivity(Class<?> destinationClass, boolean finish) {
        goToActivity(destinationClass, finish, false);
    }

    @Override
    public void goToActivity (Class<?> destinationClass, boolean finish, boolean clearAll) {
        Intent intent = new Intent(this, destinationClass);
        if (clearAll) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        goToActivity(intent, finish);
    }

    @Override
    public void goToActivity(Intent intent) {
        goToActivity(intent, false);
    }

    @Override
    public void goToActivity(Intent intent, boolean finish) {
        startActivity(intent);
        if (finish) finish();
    }

    @Override
    public boolean checkPermission(String permission, int permissionCode) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{permission}, permissionCode);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkPermissions() {
        for (String permission : Config.permissions.keySet()) {
            boolean allowed = checkPermission(permission, Config.permissions.get(permission));
            if (!allowed) return false;
        }
        return true;
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void render() {
        ButterKnife.bind(this);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
