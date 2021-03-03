package com.gyasistory.androids.graphqltest.features.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gyasistory.androids.graphqltest.R
import com.gyasistory.androids.graphqltest.databinding.FragmentCharactersBinding
import com.gyasistory.androids.graphqltest.features.character.adapter.CharacterListAdapter
import com.gyasistory.androids.graphqltest.features.character.viewmodel.CharacterDataModel



class CharacterFragment : Fragment() {
    companion object{
        const val TAG = "CharacterFragment"
    }
    private val viewModel: CharacterDataModel by viewModels()
    private lateinit var mainView: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainView = FragmentCharactersBinding.inflate(inflater, container, false)
        mainView.mainCharacterView.adapter = CharacterListAdapter()
        return mainView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characters.observe(viewLifecycleOwner){
            (mainView.mainCharacterView.adapter as CharacterListAdapter).characters = it
        }
    }

}