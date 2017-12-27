package iammert.com.flickrclient.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iammert.com.flickrclient.ui.detail.ImageDetailActivity;
import iammert.com.flickrclient.ui.feed.FeedActivity;

/**
 * Created by mertsimsek on 11/12/2017.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract FeedActivity contributeFeedActivity();

    @ContributesAndroidInjector
    abstract ImageDetailActivity contributeImageDetailActivity();
}
