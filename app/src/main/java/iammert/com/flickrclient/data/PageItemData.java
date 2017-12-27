package iammert.com.flickrclient.data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by mertsimsek on 26/12/2017.
 */

public class PageItemData<T> {

    public enum Status {
        LOADING, COMPLETE, ERROR
    }

    private Status status;

    private T data;

    public PageItemData(@Nonnull Status status, @Nullable T data) {
        this.status = status;
        this.data = data;
    }

    public static <T> PageItemData<T> complete(@Nullable T data) {
        return new PageItemData<>(Status.COMPLETE, data);
    }

    public static <T> PageItemData<T> loading(@Nullable T data) {
        return new PageItemData<>(Status.LOADING, data);
    }

    public static <T> PageItemData<T> error(@Nullable T data) {
        return new PageItemData(Status.ERROR, null);
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
