package com.gyasistory.androids.graphqltest.features.character

import androidx.lifecycle.ViewModel
import com.gyasistory.androids.graphqltest.features.character.viewmodel.CharacterDataModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CharactersModule {
    @Binds
    @IntoMap
    internal abstract fun characterDataModule(viewModel: CharacterDataModel): ViewModel
}