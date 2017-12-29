package dagger.rxjava.project.com.usersearchapp.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by bineesh on 29/12/17.
 */
open class BasePresenter<V : BaseView> {

    @Inject
    lateinit var mView: V

    fun getView(): V? {
        return mView
    }

    protected fun <T> subscribe(observable: Observable<T>?, observer: Observer<T>) {
        observable?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(observer)
    }
}