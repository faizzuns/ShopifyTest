package shopify.user.shopifytest.core.service.retrofit;


import shopify.user.shopifytest.core.service.ApiServices;

public class RetrofitServices {

    public static ApiServices sendRequest() {
        return RetrofitClient.client().create(ApiServices.class);
    }

}
