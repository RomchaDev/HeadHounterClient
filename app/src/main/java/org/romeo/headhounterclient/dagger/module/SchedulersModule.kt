package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
class SchedulersModule {

    @Named("MAIN")
    @Provides
    fun mainScheduler(): Scheduler = AndroidSchedulers.mainThread()
}

const val MAIN_SCHEDULER_KEY = "MAIN"