package com.gyasistory.androids.graphqltest.features.character

import androidx.lifecycle.ViewModel
import com.gyasistory.androids.graphqltest.features.character.viewmodel.CharacterDataModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.ccci.gto.android.common.dagger.viewmodel.ViewModelKey

@Module
abstract class CharactersModule {
    @Binds
    @IntoMap
    @ViewModelKey(CharacterDataModel::class)
    internal abstract fun characterDataModule(viewModel: CharacterDataModel): ViewModel
}