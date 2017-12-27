package iammert.com.flickrclient.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import iammert.com.flickrclient.ui.feed.FeedViewModel;

/**
 * Created by mertsimsek on 11/12/2017.
 */

@Module
public abstract class ViewModelModule {

    @ViewModelKey(FeedViewModel.class)
    @IntoMap
    @Binds
    abstract ViewModel provideFeedViewModel(FeedViewModel feedViewModel);

    @Binds
    abstract ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory viewModelFactory);

}
