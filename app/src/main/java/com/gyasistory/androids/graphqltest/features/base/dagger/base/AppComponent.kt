package com.gyasistory.androids.graphqltest.features.base.dagger.base

import com.gyasistory.androids.graphqltest.features.base.dagger.app.AppModule
import com.gyasistory.androids.graphqltest.GraphQLTestApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<GraphQLTestApp>