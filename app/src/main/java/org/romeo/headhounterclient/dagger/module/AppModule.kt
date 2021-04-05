package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.navigation.App

@Module
class AppModule(private val app: App) {
    @Provides
    fun app() = app
}