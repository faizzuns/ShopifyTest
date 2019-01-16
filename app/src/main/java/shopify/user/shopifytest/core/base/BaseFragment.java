package shopify.user.shopifytest.core.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;

public class BaseFragment<P> extends Fragment implements BaseFragmentView<P> {

    protected P basePresenter;


    @Override
    public void attachPresenter(P presenter) {
        basePresenter = presenter;
    }

    @Override
    public void render(View view) {
        ButterKnife.bind(this, view);
    }

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
        Intent intent = new Intent(getApplicationContext(), destinationClass);
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
        if (finish && getActivity() != null) getActivity().finish();
    }

    @Override
    public void render() {

    }

    @Override
    public void hideKeyboard() {
        if (getActivity() != null) ((BaseActivity)getActivity()).hideKeyboard();
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getApplicationContext() {
        return getContext();
    }
}
