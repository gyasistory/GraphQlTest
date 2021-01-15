package com.gyasistory.androids.graphqltest

import androidx.appcompat.app.AppCompatDelegate
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class GraphQLTestApp : DaggerApplication() {

    override fun onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate()
    }

    // region Dagger
    protected var appComponent: AppComponent? = null

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        appComponent =
            DaggerAppComponent.builder().appModule(AppModule(this)).build()
        return appComponent
    }
    //endregion
}