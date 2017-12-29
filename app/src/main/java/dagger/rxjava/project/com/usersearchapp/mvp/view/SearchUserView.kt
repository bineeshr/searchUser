package dagger.rxjava.project.com.usersearchapp.mvp.view

import dagger.rxjava.project.com.usersearchapp.base.BaseView
import dagger.rxjava.project.com.usersearchapp.mvp.model.SearchUser

/**
 * Created by bineesh on 29/12/17.
 */
interface SearchUserView :BaseView {
    fun getSearchUser( searchUser: SearchUser?)
}