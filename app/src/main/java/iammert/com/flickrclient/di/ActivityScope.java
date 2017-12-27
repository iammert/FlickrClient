package iammert.com.flickrclient.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by mertsimsek on 11/12/2017.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
