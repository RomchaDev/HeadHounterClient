package org.romeo.headhounterclient.dagger.module.db

import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.room.db.HeadHaunterDb
import org.romeo.headhounterclient.navigation.App
import javax.inject.Named

@Module
class DbModule {

    @Provides
    fun database(app: App, @Named("DB_NAME") dbName: String) =
        Room.databaseBuilder(
            app,
            HeadHaunterDb::class.java,
            dbName
        ).build()

    @Provides
    @Named("DB_NAME")
    fun dbName() = DB_NAME
}

private const val DB_NAME = "HH_DB"