package iammert.com.flickrclient.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by mertsimsek on 27/12/2017.
 */
@Parcel
public class ContentData {
    @SerializedName("_content")
    private String content;

    public ContentData() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
