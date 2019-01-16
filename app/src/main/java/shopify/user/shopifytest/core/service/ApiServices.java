package shopify.user.shopifytest.core.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import shopify.user.shopifytest.core.model.collections.CustomCollections;
import shopify.user.shopifytest.core.model.collects.Collects;
import shopify.user.shopifytest.core.model.product.Products;

public interface ApiServices {

    @GET("custom_collections.json?page=1")
    Call<CustomCollections> callCollections(@Query("access_token") String token);

    @GET("products.json?page=1")
    Call<Products> callProducts(@Query("access_token") String token, @Query("ids") String ids);

    @GET("collects.json?page=1")
    Call<Collects> callCollects(@Query("collection_id") Long collectionId,
                                @Query("access_token") String token);

}
