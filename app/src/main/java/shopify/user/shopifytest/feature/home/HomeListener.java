package shopify.user.shopifytest.feature.home;

import shopify.user.shopifytest.core.base.BaseActivityView;
import shopify.user.shopifytest.core.base.BaseLifecycle;

public interface HomeListener {

    interface View extends BaseActivityView {
        void stopSwipeRefresh();
        void showList();
        void hideList();
        void setUpList();
    }

    interface Presenter extends BaseLifecycle {
        void search();
        CollectionAdapter getCollectionAdapter();
    }

}
