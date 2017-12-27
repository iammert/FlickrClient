package iammert.com.flickrclient.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.parceler.Parcels;

import dagger.android.support.DaggerAppCompatActivity;
import iammert.com.flickrclient.R;
import iammert.com.flickrclient.data.model.RecentPhotoInfo;
import iammert.com.flickrclient.databinding.ActivityImageDetailBinding;

/**
 * Created by mertsimsek on 27/12/2017.
 */

public class ImageDetailActivity extends DaggerAppCompatActivity {

    private static final String KEY_BUNDLE_RECENT_PHOTO = "KEY_BUNDLE_RECENT_PHOTO";

    private ActivityImageDetailBinding binding;
    private RecentPhotoInfo recentPhotoInfo;

    public static Intent newIntent(Context context, RecentPhotoInfo recentPhotoInfo) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BUNDLE_RECENT_PHOTO, Parcels.wrap(recentPhotoInfo));
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail);
        initBundle();
        initUI();
    }

    private void initBundle() {
        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            recentPhotoInfo = Parcels.unwrap(bundle.getParcelable(KEY_BUNDLE_RECENT_PHOTO));
        }
    }

    private void initUI() {
        if (recentPhotoInfo == null) {
            return;
        }
        binding.setImageUrl(recentPhotoInfo.getImageUrl());
    }
}
