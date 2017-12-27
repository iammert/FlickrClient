package iammert.com.flickrclient.data;

import iammert.com.flickrclient.data.model.PersonInfoResponse;
import iammert.com.flickrclient.data.model.RecentPhotosResponse;
import iammert.com.flickrclient.data.model.SizesResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public interface ApiService {

    String METHOD_GET_RECENT = "flickr.photos.getRecent";
    String METHOD_GET_PERSON_INFO = "flickr.people.getInfo";
    String METHOD_GET_IMAGE_SIZES = "flickr.photos.getSizes";

    @GET("rest/")
    Single<RecentPhotosResponse> getCurrentPhotos(@Query("method") String methodName,
                                                  @Query("page") int page,
                                                  @Query("per_page") int parPage);

    @GET("rest/")
    Single<SizesResponse> getImageSizes(@Query("method") String methodName,
                                        @Query("photo_id") String photoId);

    @GET("rest/")
    Single<PersonInfoResponse> getPersonInfo(@Query("method") String methodName,
                                             @Query("user_id") String userId);
}
