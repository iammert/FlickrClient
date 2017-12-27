package iammert.com.flickrclient.ui.feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import iammert.com.flickrclient.data.PageItemData;
import iammert.com.flickrclient.data.model.RecentPhotoInfo;
import iammert.com.flickrclient.data.repository.FeedRepository;
import iammert.com.flickrclient.util.RxViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public class FeedViewModel extends RxViewModel {

    private static final int INITIAL_PAGE = 0;

    private int currentPage = INITIAL_PAGE;

    private final FeedRepository feedRepository;

    private MutableLiveData<List<RecentPhotoInfo>> photosInfoLiveData = new MutableLiveData<>();

    private MutableLiveData<Boolean> isLoadingLiveData = new MutableLiveData<>();

    @Inject
    public FeedViewModel(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
        isLoadingLiveData.setValue(true);
        loadNextPage();
    }

    public void loadNextPage() {
        currentPage++;
        isLoadingLiveData.setValue(true);
        disposable.add(feedRepository.getCurrentPhotos(currentPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::addPhoto));
    }

    public LiveData<List<RecentPhotoInfo>> getPhotos() {
        return photosInfoLiveData;
    }

    public LiveData<Boolean> getIsLoading(){
        return isLoadingLiveData;
    }

    private void addPhoto(PageItemData<RecentPhotoInfo> recentPhotoInfo) {
        final List<RecentPhotoInfo> list = new ArrayList<>();
        if (photosInfoLiveData.getValue() != null) {
            list.addAll(photosInfoLiveData.getValue());
        }
        list.add(recentPhotoInfo.getData());
        photosInfoLiveData.setValue(list);

        if (recentPhotoInfo.getStatus() == PageItemData.Status.COMPLETE) {
            isLoadingLiveData.setValue(false);
        }
    }
}
