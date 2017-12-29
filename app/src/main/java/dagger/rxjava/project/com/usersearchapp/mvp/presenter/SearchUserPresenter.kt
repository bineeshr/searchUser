package dagger.rxjava.project.com.usersearchapp.mvp.presenter

import dagger.rxjava.project.com.usersearchapp.api.UserSearchApi
import dagger.rxjava.project.com.usersearchapp.base.BasePresenter
import dagger.rxjava.project.com.usersearchapp.mvp.model.SearchUser
import dagger.rxjava.project.com.usersearchapp.mvp.view.SearchUserView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by bineesh on 29/12/17.
 */
class SearchUserPresenter @Inject() constructor() : BasePresenter<SearchUserView>(), Observer<SearchUser> {
    @Inject lateinit var mApiService: UserSearchApi

    fun searchUser(searchQuery: String) {
        val locationResponseObservable = mApiService.searchUser(searchQuery, "followers", "desc")
        subscribe(locationResponseObservable, this)
    }

    override fun onNext(value: SearchUser?) {
        getView()?.getSearchUser(value)
    }

    override fun onError(e: Throwable?) {
    }

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onComplete() {
    }

}