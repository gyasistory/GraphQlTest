package com.gyasistory.androids.graphqltest.features.character.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.gyasistory.androids.graphqltest.FeedResultsQuery
import com.gyasistory.androids.graphqltest.features.base.GraphQLDataClientProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CharacterDataModel(application: Application) : AndroidViewModel(application) {
    private val apolloClient = GraphQLDataClientProvider.getInstance(application).client
    val characters = MutableLiveData<List<FeedResultsQuery.Result>>().apply {
        setData()
    }

    private fun setData() {
        apolloClient.query(FeedResultsQuery.builder().build()).watcher()
            .enqueueAndWatch(object : ApolloCall.Callback<FeedResultsQuery.Data>() {
                override fun onFailure(e: ApolloException) {
                    GlobalScope.launch(Dispatchers.Main) {
                        characters.value = emptyList()
                    }
                }

                override fun onResponse(response: Response<FeedResultsQuery.Data>) {
                    GlobalScope.launch(Dispatchers.Main) {
                        characters.value = response.data?.characters()?.results()
                    }
                }
            })
    }
}