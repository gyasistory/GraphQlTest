package com.gyasistory.androids.graphqltest.features

import com.gyasistory.androids.graphqltest.MainActivity
import com.gyasistory.androids.graphqltest.features.character.CharactersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [CharactersModule::class])
abstract class FeaturesModule {
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
}