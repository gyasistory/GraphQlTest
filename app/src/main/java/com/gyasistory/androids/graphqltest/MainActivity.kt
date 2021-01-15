package com.gyasistory.androids.graphqltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory
import com.apollographql.apollo.exception.ApolloException
import javax.inject.Inject

const val TAG = "MainActivity"

class MainActivity @Inject constructor() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val okHttpClient = OkHttpClient.Builder().build()
        val sqlNormalizedCacheFactory = SqlNormalizedCacheFactory(this, "test.db")

        val apolloClient = ApolloClient.builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .normalizedCache(sqlNormalizedCacheFactory)
            .build()

        apolloClient.query(FeedResultsQuery.builder().build()).enqueue(object : ApolloCall.Callback<FeedResultsQuery.Data>() {
            override fun onResponse(response: Response<FeedResultsQuery.Data>) {
//                response.data?.characters?.results()?.forEach {
//                    Log.i(TAG, it.image ?: "")
//                }
            }

            override fun onFailure(e: ApolloException) {
                TODO("Not yet implemented")
            }

        })
    }
}