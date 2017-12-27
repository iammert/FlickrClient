package iammert.com.flickrclient.data.repository;

import javax.inject.Inject;
import javax.inject.Named;

import iammert.com.flickrclient.data.FeedDataSource;
import iammert.com.flickrclient.data.PageItemData;
import iammert.com.flickrclient.data.model.RecentPhotoInfo;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public class FeedRepository implements FeedDataSource {

    private final FeedDataSource feedDataSource;

    @Inject
    public FeedRepository(@Named("remote") FeedDataSource feedDataSource) {
        this.feedDataSource = feedDataSource;
    }

    @Override
    public Flowable<PageItemData<RecentPhotoInfo>> getCurrentPhotos(int page) {
        return feedDataSource.getCurrentPhotos(page)
                .subscribeOn(Schedulers.io());
    }
}
