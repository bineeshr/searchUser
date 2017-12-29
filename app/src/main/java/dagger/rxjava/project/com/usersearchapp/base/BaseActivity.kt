package dagger.rxjava.project.com.usersearchapp.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import dagger.rxjava.project.com.usersearchapp.application.SearchApplication
import dagger.rxjava.project.com.usersearchapp.di.component.ApplicationComponent

/**
 * Created by bineesh on 29/12/17.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        onViewReady(savedInstanceState, intent)

    }

    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        resolveDaggerDependency()
    }

    abstract fun getContentView(): Int
    protected open fun resolveDaggerDependency() {}

    protected fun getApplicationComponent(): ApplicationComponent? {
        return (application as SearchApplication).getApplicationComponent()
    }

    protected fun showBackArrow() {
        val supportActionBar = supportActionBar

        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true)
            supportActionBar.setDisplayShowHomeEnabled(true)
            supportActionBar.setDisplayShowTitleEnabled(false)
        }
    }

}