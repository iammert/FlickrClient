package iammert.com.flickrclient.ui.feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import iammert.com.flickrclient.data.model.RecentPhotoInfo;
import iammert.com.flickrclient.databinding.ItemFeedBinding;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedPhotoItemViewHolder> {

    interface OnItemClickListener {
        void onItemClicked(RecentPhotoInfo photoInfo);
    }

    private List<RecentPhotoInfo> photos;
    private OnItemClickListener onItemClickListener;

    @Inject
    public FeedAdapter() {
        photos = new ArrayList<>();
    }

    public void setPhotos(List<RecentPhotoInfo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public FeedPhotoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return FeedPhotoItemViewHolder.create(parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(FeedPhotoItemViewHolder holder, int position) {
        holder.bind(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    static class FeedPhotoItemViewHolder extends RecyclerView.ViewHolder {

        static FeedPhotoItemViewHolder create(ViewGroup parent, OnItemClickListener itemClickListener) {
            ItemFeedBinding binding = ItemFeedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new FeedPhotoItemViewHolder(binding, itemClickListener);
        }

        private final ItemFeedBinding itemFeedBinding;

        public FeedPhotoItemViewHolder(ItemFeedBinding itemFeedBinding, OnItemClickListener itemClickListener) {
            super(itemFeedBinding.getRoot());
            this.itemFeedBinding = itemFeedBinding;
            this.itemFeedBinding.picture.setOnClickListener(view -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClicked(itemFeedBinding.getPhoto());
                }
            });
        }

        public void bind(RecentPhotoInfo recentPhotoInfo) {
            itemFeedBinding.setPhoto(recentPhotoInfo);
            itemFeedBinding.executePendingBindings();
        }
    }
}
