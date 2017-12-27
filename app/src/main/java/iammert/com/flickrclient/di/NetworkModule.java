package iammert.com.flickrclient.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iammert.com.flickrclient.BuildConfig;
import iammert.com.flickrclient.data.ApiService;
import iammert.com.flickrclient.data.FeedDataSource;
import iammert.com.flickrclient.data.RequestInterceptor;
import iammert.com.flickrclient.data.remote.RemoteFeedDataSource;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mertsimsek on 11/12/2017.
 */
@Module
public class NetworkModule {

    private static final long TIMEOUT_IN_SEC = 10;

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLogginInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor);
        }
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    @Named("remote")
    FeedDataSource provideRemoteFeedDataSource(ApiService apiService) {
        return new RemoteFeedDataSource(apiService);
    }
}
