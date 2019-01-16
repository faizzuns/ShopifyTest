package shopify.user.shopifytest.core.base;

public interface BaseActivityView extends BaseView{
    boolean checkPermission(String permission, int permissionCode);
    boolean checkPermissions();
}
