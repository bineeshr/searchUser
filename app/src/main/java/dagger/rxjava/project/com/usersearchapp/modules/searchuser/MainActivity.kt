package dagger.rxjava.project.com.usersearchapp.modules.searchuser

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import dagger.rxjava.project.com.usersearchapp.R
import dagger.rxjava.project.com.usersearchapp.base.BaseActivity
import dagger.rxjava.project.com.usersearchapp.di.component.DaggerSearchUserComponent
import dagger.rxjava.project.com.usersearchapp.di.module.SearchUserModule
import dagger.rxjava.project.com.usersearchapp.mvp.model.SearchUser
import dagger.rxjava.project.com.usersearchapp.mvp.presenter.SearchUserPresenter
import dagger.rxjava.project.com.usersearchapp.mvp.view.SearchUserView
import javax.inject.Inject
import android.widget.TextView
import android.text.Editable
import android.text.TextWatcher
import dagger.rxjava.project.com.usersearchapp.modules.searchuser.adapter.SearchUserAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(),SearchUserView {
    private var mAdapter:SearchUserAdapter?=null;
    override fun getSearchUser(searchUser: SearchUser?) {
        if(searchUser?.items?.size!=0) {
            mAdapter?.updateUserList(searchUser?.items)
        }
    }

    @Inject lateinit var mPresenter: SearchUserPresenter

    override fun getContentView(): Int {
        return R.layout.activity_main
    }


    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        super.onViewReady(savedInstanceState, intent)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        val layoutManager = mLayoutManager
        recycle_user_list.layoutManager = layoutManager
        recycle_user_list.itemAnimator = DefaultItemAnimator()
        recycle_user_list.addItemDecoration(
                DividerItemDecoration(this, layoutManager.getOrientation()))
        mAdapter= SearchUserAdapter(this, mutableListOf())
        recycle_user_list.adapter = mAdapter
        edit_search_user.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                mPresenter.searchUser(s.toString())

            }
        })

    }

    override fun resolveDaggerDependency() {
        super.resolveDaggerDependency()
        DaggerSearchUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .searchUserModule(SearchUserModule(this))
                .build().inject(this)
    }

}
