package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.navigation.screens.IScreens
import org.romeo.headhounterclient.navigation.screens.Screens
import javax.inject.Singleton

@Module
class ScreensModule {

    @Provides
    @Singleton
    fun screens(): IScreens = Screens()
}