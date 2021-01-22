package com.gyasistory.androids.graphqltest

import android.app.Application
import android.content.Context
import com.gyasistory.androids.graphqltest.core.CoreModule
import com.gyasistory.androids.graphqltest.features.FeaturesModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    FeaturesModule::class,
    CoreModule::class
])
class AppModule(private val application: GraphQLTestApp) {
    //Do not really need a double-check-cache reference for field-returns. (So no @Singleton)
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun providesContext(): Context {
        return application
    }
}