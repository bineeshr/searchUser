package dagger.rxjava.project.com.usersearchapp.di.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by bineesh on 18/10/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity
