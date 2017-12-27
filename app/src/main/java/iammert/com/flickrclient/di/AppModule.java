package iammert.com.flickrclient.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iammert.com.flickrclient.FlickrClientApp;

/**
 * Created by mertsimsek on 11/12/2017.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideApplicationContext(FlickrClientApp app) {
        return app;
    }
}
