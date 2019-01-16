package shopify.user.shopifytest.core;

import android.Manifest;

import java.util.HashMap;

public class Config {

    public static final String BASE_URL = "https://shopicruit.myshopify.com/admin/";
    public static final String ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6";
    public static final long SPLASH_TIMEOUT = 2500;
    public static HashMap<String, Integer> permissions = getPermissions();
    private static final int internetCode = 1001;

    private static HashMap<String, Integer> getPermissions() {
        HashMap<String, Integer> permissions = new HashMap<>();
        permissions.put(Manifest.permission.INTERNET, internetCode);
        return permissions;
    }
}
