package com.gyasistory.androids.graphqltest

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class GraphQLTestApp : Application() {

    override fun onCreate() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate()
    }
}