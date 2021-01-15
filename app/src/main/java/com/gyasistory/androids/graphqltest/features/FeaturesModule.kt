package com.gyasistory.androids.graphqltest.features

import com.gyasistory.androids.graphqltest.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module()
abstract class FeaturesModule {
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}