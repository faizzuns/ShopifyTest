package shopify.user.shopifytest.feature.home;

public class HomePresenter implements HomeListener.Presenter {

    private HomeListener.View view;

    public HomePresenter(HomeListener.View view) {
        this.view = view;
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
    }
}
