package com.gyasistory.androids.graphqltest.features.character.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.gyasistory.androids.graphqltest.FeedResultsQuery
import javax.inject.Inject

class CharacterDataModel @Inject constructor(private val apolloClient: ApolloClient) : ViewModel() {
    val characters = MutableLiveData<List<FeedResultsQuery.Result>>().apply {
        apolloClient.query(FeedResultsQuery.builder().build()).watcher()
            .enqueueAndWatch(object : ApolloCall.Callback<FeedResultsQuery.Data>() {
                override fun onFailure(e: ApolloException) {
                    this@apply.value = emptyList()
                }

                override fun onResponse(response: Response<FeedResultsQuery.Data>) {
                    this@apply.value = response.data?.characters()?.results()
                }
            })
    }
}