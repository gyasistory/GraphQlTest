package com.gyasistory.androids.graphqltest.core

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.sql.SqlNormalizedCacheFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

const val NAME_BASE_OKHTTP = "baseOkHttp"
const val NAME_SQL_NORMALIZATION = "sqlNormalization"

private const val DATABASE_NAME = "test.db"

@Module()
class DataModule {
    @Provides
    @Singleton
    @Named(NAME_BASE_OKHTTP)
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    @Named(NAME_SQL_NORMALIZATION)
    fun provideSqlNormalizationFactory(context: Context): SqlNormalizedCacheFactory {
        return SqlNormalizedCacheFactory(context, DATABASE_NAME)
    }

    @Provides
    @Singleton
    fun provideApolloClient(
        @Named(NAME_BASE_OKHTTP) okHttpClient: OkHttpClient,
        @Named(NAME_SQL_NORMALIZATION) sqlNormalizedCacheFactory: SqlNormalizedCacheFactory
    ): ApolloClient? {
        return ApolloClient.builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .normalizedCache(sqlNormalizedCacheFactory)
            .okHttpClient(okHttpClient)
            .build()
    }
}
