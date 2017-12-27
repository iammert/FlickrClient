package iammert.com.flickrclient;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import iammert.com.flickrclient.di.DaggerAppComponent;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public class FlickrClientApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
