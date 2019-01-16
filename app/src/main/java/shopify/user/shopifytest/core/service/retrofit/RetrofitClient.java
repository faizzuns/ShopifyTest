package shopify.user.shopifytest.core.service.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shopify.user.shopifytest.core.Config;


/**
 * Created by User on 09/11/2017.
 * @author Ahmad Faiz Sahupala
 *
 * pemanggilan retrofit
 */

class RetrofitClient {
    static Retrofit client() {
        Gson gson = new GsonBuilder().
                setLenient().create();
        HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().addInterceptor(logging);

        return new Retrofit.Builder().
                baseUrl(Config.BASE_URL).
                client(okHttpClient.build()).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
    }
}
