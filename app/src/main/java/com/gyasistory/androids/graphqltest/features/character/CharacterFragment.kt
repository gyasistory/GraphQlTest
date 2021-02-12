package com.gyasistory.androids.graphqltest.features.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gyasistory.androids.graphqltest.R
import com.gyasistory.androids.graphqltest.features.character.viewmodel.CharacterDataModel

const val TAG = "CharacterFragment"

class CharacterFragment : Fragment() {
    private val viewModel: CharacterDataModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characters.observe(viewLifecycleOwner){
            it.forEach { character ->
                Log.i(TAG, "onViewCreated: \n name: ${character.name()}")
            }
        }
    }

}