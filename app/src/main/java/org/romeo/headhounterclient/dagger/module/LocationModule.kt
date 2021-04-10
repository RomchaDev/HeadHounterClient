package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.main.fragments.location.AndroidLocationManager
import org.romeo.headhounterclient.model.repo.ILocationRepo
import org.romeo.headhounterclient.navigation.App

@Module
class LocationModule {
    @Provides
    fun locationManager(app: App): ILocationRepo =
        AndroidLocationManager(app)
}