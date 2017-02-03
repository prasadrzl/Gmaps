package gmaps.com.gmaps.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gmaps.com.gmaps.base.Constants;
import gmaps.com.gmaps.network.GitApiService;
import gmaps.com.gmaps.network.MoviesApiService;
import gmaps.com.gmaps.network.SquareApiService;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Durga Prasad on 24-10-2016.
 */

@Module
public class NetworkModule {
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 30;
    private static final int CONNECTION_TIMEOUT = 10;

    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Named("square_http_client")
    @Provides
    @Singleton
    OkHttpClient providesSquareOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    HttpUrl httpUrl = request.url().newBuilder()
                            .addQueryParameter("ll","12.932919,77.602866")
                            .addQueryParameter("client_id","KWDQW5IY3QN15ACZY4HRFGMZT1QIH33JUBDL5U0LG4YPJ2CG")
                            .addQueryParameter("client_secret","MEI5VUQVLRACJWLPATIZRHSBWR0FZUHF1SOGZYAXHVGAP4B2")
                            .build();
                    request = request.newBuilder().url(httpUrl).build();
                    return chain.proceed(request);
                })
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache).build();
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Named("git_http_client")
    @Provides
    @Singleton
    OkHttpClient providesGitOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .cache(cache).build();
    }

    @Named("movies_http_client")
    @Provides
    @Singleton
    OkHttpClient providesMoviesOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    HttpUrl httpUrl = request.url().newBuilder()
                            .addQueryParameter("api_key","50cbaf32-aa53-434a-817c-07fa75220de8")
                            .build();
                    request = request.newBuilder().url(httpUrl).build();
                    return chain.proceed(request);
                })
                .cache(cache).build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }


    @Provides
    @Named("movies_url")
    @Singleton
    String provideMoviesBaseUrl() {
        return Constants.BASE_MOVIES_URL;
    }

    @Provides
    @Named("square_url")
    @Singleton
    String provideSquareBaseUrl() {
        return Constants.BASE_SQUARE_URL;
    }

    @Provides
    @Named("git_url")
    @Singleton
    String provideGitBaseUrl() {
        return Constants.BASE_GIT_URL;
    }

    @Provides
    @Singleton
    @Named("git_retrofit")
    Retrofit provideGitRetrofit(@Named("git_http_client")OkHttpClient okHttpClient, Gson gson,@Named("git_url") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    @Named("movies_retrofit")
    Retrofit provideMoviesRetrofit(@Named("movies_http_client") OkHttpClient okHttpClient, Gson gson,@Named("movies_url") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    @Named("square_retrofit")
    Retrofit provideSquareRetrofit(@Named("square_http_client") OkHttpClient okHttpClient, Gson gson,@Named("square_url") String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    GitApiService provideGitApiService(@Named("git_retrofit") Retrofit retrofit) {
        return retrofit.create(GitApiService.class);
    }

    @Provides
    SquareApiService provideSquareApiService(@Named("square_retrofit") Retrofit retrofit) {
        return retrofit.create(SquareApiService.class);
    }

    @Provides
    MoviesApiService provideMoviesApiService(@Named("movies_retrofit") Retrofit retrofit) {
        return retrofit.create(MoviesApiService.class);
    }
}
