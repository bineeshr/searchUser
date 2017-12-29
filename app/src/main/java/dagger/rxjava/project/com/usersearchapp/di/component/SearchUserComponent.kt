package dagger.rxjava.project.com.usersearchapp.di.component

import dagger.Component
import dagger.rxjava.project.com.usersearchapp.di.module.SearchUserModule
import dagger.rxjava.project.com.usersearchapp.di.scope.PerActivity
import dagger.rxjava.project.com.usersearchapp.modules.searchuser.MainActivity

/**
 * Created by bineesh on 29/12/17.
 */
@PerActivity
@Component(modules = arrayOf(SearchUserModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface SearchUserComponent {
    fun inject(activity: MainActivity)

}