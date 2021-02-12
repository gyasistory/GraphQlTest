package com.gyasistory.androids.graphqltest.features.base.dagger.activity

import com.gyasistory.androids.graphqltest.features.base.dagger.base.AppDependencies
import com.gyasistory.androids.graphqltest.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [AppDependencies::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}