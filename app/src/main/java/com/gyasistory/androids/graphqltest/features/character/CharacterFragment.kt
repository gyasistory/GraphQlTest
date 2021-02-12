package com.gyasistory.androids.graphqltest.features.character

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import org.w3c.dom.CharacterData
import javax.inject.Inject

class CharacterFragment : Fragment() {
    private val viewModel: CharacterData by viewModels { viewModelFactory}

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
}