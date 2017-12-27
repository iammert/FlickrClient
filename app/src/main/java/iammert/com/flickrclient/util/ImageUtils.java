package iammert.com.flickrclient.util;

import iammert.com.flickrclient.data.model.Person;

/**
 * Created by mertsimsek on 11/12/2017.
 */

public final class ImageUtils {

    private ImageUtils() {
        //no-instance
    }

    public static String getProfileImage(Person person) {
        if (person == null) {
            return "";
        }

        return "http://farm" + person.getIconfarm() + ".staticflickr.com/"
                + person.getIconserver()
                + "/buddyicons/" + person.getNsid() + "_l.jpg";
    }

}
