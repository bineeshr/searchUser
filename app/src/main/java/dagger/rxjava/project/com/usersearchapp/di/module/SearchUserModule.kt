package dagger.rxjava.project.com.usersearchapp.di.module

import dagger.Module
import dagger.Provides
import dagger.rxjava.project.com.usersearchapp.api.UserSearchApi
import dagger.rxjava.project.com.usersearchapp.di.scope.PerActivity
import dagger.rxjava.project.com.usersearchapp.mvp.view.SearchUserView
import retrofit2.Retrofit

/**
 * Created by bineesh on 29/12/17.
 */
@Module
class SearchUserModule (var mView:SearchUserView) {
    @PerActivity
    @Provides
    internal fun provideApiService(retrofit: Retrofit): UserSearchApi{
        return retrofit.create(UserSearchApi::class.java)
    }

    @PerActivity
    @Provides
    internal fun provideView(): SearchUserView {
        return mView
    }
}