package dagger.rxjava.project.com.usersearchapp.application

import android.app.Application
import dagger.rxjava.project.com.usersearchapp.di.component.ApplicationComponent
import dagger.rxjava.project.com.usersearchapp.di.component.DaggerApplicationComponent
import dagger.rxjava.project.com.usersearchapp.di.module.ApplicationModule

/**
 * Created by bineesh on 29/12/17.
 */
class SearchApplication :Application() {
        private val mApplicationComponent: ApplicationComponent by lazy {
            DaggerApplicationComponent
                    .builder()
                    .applicationModule(ApplicationModule(this, "https://api.github.com/"))
                    .build()
        }

        override fun onCreate() {
            super.onCreate()
            initializeApplicationComponent()
        }


        private fun initializeApplicationComponent() {

        }

        fun getApplicationComponent(): ApplicationComponent? {
            return mApplicationComponent
        }

        override fun onTerminate() {
            super.onTerminate()
        }

}