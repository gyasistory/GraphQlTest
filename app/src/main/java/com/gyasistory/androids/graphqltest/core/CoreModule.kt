package com.gyasistory.androids.graphqltest.core

import androidx.lifecycle.ViewModelProvider
import dagger.Module

@Module(includes = [DataModule::class])
abstract class CoreModule {
    interface Dependencies {
        fun viewModelProviderFactory(): ViewModelProvider.Factory
    }
}