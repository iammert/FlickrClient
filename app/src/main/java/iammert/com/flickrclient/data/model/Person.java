package iammert.com.flickrclient.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by mertsimsek on 11/12/2017.
 */
@Parcel
public class Person {
    @SerializedName("id")
    private String id;
    @SerializedName("nsid")
    private String nsid;
    @SerializedName("username")
    private ContentData username;
    @SerializedName("realname")
    private ContentData realName;
    private String iconserver;
    private String iconfarm;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public ContentData getUsername() {
        return username;
    }

    public void setUsername(ContentData username) {
        this.username = username;
    }

    public ContentData getRealName() {
        return realName;
    }

    public void setRealName(ContentData realName) {
        this.realName = realName;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public String getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(String iconfarm) {
        this.iconfarm = iconfarm;
    }
}
