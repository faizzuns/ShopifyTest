package shopify.user.shopifytest.feature.detail;

import shopify.user.shopifytest.core.base.BaseActivityView;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public class DetailListener {
    interface View extends BaseActivityView {
        void showList();
        void hideList();
        void setUpList();
        void stopSwipeRefresh();
        void scrollToTop();

        void showBasicCollectionInformation(String title, String desc, String url);
    }

    interface Presenter extends BaseLifecycle {

        void searchProducts(Long id);
        void iterateResult(String ids);
        void setContent(String title, String url);

        ProductAdapter getProductAdapter();
    }
}
