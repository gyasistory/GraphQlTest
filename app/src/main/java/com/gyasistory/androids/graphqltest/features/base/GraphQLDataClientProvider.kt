package com.gyasistory.androids.graphqltest.features.base

import android.app.Application
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory
import okhttp3.OkHttpClient


private const val DATABASE_NAME = "test.db"

class GraphQLDataClientProvider(application: Application) {
    companion object : SingletonHolder<GraphQLDataClientProvider, Application>(::GraphQLDataClientProvider)

    private val okHttpClient = OkHttpClient.Builder().build()
    private val sqlNormalizedCacheFactory = SqlNormalizedCacheFactory(application, DATABASE_NAME)
    val client =  ApolloClient.builder()
        .serverUrl("https://rickandmortyapi.com/graphql")
        .normalizedCache(sqlNormalizedCacheFactory)
        .okHttpClient(okHttpClient)
        .build()
}