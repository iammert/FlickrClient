package iammert.com.flickrclient.data;

import android.support.annotation.NonNull;

import java.io.IOException;

import iammert.com.flickrclient.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public class RequestInterceptor implements Interceptor {

    private static final String API_KEY = "api_key";
    private static final String FORMAT = "format";
    private static final String JSON = "json";
    private static final String JSON_CALLBACK = "nojsoncallback";
    private static final String JSON_CALLBACK_VALUE = "1";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                .addQueryParameter(FORMAT, JSON)
                .addQueryParameter(JSON_CALLBACK, JSON_CALLBACK_VALUE)
                .build();

        Request request = originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
