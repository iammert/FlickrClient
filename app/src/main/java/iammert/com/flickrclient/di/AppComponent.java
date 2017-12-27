package iammert.com.flickrclient.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import iammert.com.flickrclient.FlickrClientApp;

/**
 * Created by mertsimsek on 11/12/2017.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBuilderModule.class,
        ViewModelModule.class})
public interface AppComponent extends AndroidInjector<FlickrClientApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<FlickrClientApp> {
    }
}
