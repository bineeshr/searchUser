package dagger.rxjava.project.com.usersearchapp.di.component

import android.content.Context
import dagger.Component
import dagger.rxjava.project.com.usersearchapp.di.module.ApplicationModule
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
     fun exposeRetrofit(): Retrofit
     fun exposeContext(): Context
}