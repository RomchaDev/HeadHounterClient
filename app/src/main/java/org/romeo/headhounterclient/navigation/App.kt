package org.romeo.headhounterclient.navigation

import android.app.Application
import org.romeo.headhounterclient.dagger.component.DaggerMainComponent
import org.romeo.headhounterclient.dagger.component.MainComponent
import org.romeo.headhounterclient.dagger.module.AppModule

class App : Application() {

    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        instance = this

        mainComponent = DaggerMainComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        super.onCreate()
    }

    companion object {
        lateinit var instance: App
    }
}