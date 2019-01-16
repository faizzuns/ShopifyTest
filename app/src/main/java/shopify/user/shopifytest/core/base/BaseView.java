package shopify.user.shopifytest.core.base;

import android.content.Context;
import android.content.Intent;

public interface BaseView {

    void goToActivity(Class<?> destinationClass);
    void goToActivity(Class<?> destinationClass, boolean finish);
    void goToActivity(Class<?> destinationClass, boolean finish, boolean clearAll);
    void goToActivity(Intent intent);
    void goToActivity(Intent intent, boolean finish);

    void render();
    void hideKeyboard();

    void displayMessage(String message);
    Context getApplicationContext();
}
