package shopify.user.shopifytest.core;

import android.Manifest;

import java.util.HashMap;

public class Config {

    public static final String BASE_URL = "https://api2.edukasystem.id";
    public static final String ACCESS_TOKEN = "";
    public static HashMap<String, Integer> permissions = getPermissions();
    private static final int internetCode = 1001;

    private static HashMap<String, Integer> getPermissions() {
        HashMap<String, Integer> permissions = new HashMap<>();
        permissions.put(Manifest.permission.INTERNET, internetCode);
        return permissions;
    }
}
