package iammert.com.flickrclient.data;

import iammert.com.flickrclient.data.model.RecentPhotoInfo;
import io.reactivex.Flowable;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public interface FeedDataSource {

    Flowable<PageItemData<RecentPhotoInfo>> getCurrentPhotos(int page);
}
