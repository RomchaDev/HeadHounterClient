package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.api.IRetrofitWorker
import org.romeo.headhounterclient.model.repo.FullVacanciesRepo
import org.romeo.headhounterclient.model.repo.IFullVacanciesRepo
import org.romeo.headhounterclient.model.repo.IShortVacanciesRepo
import org.romeo.headhounterclient.model.repo.ShortVacanciesRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun shortVacanciesRepo(worker: IRetrofitWorker): IShortVacanciesRepo =
        ShortVacanciesRepo(worker)

    @Provides
    @Singleton
    fun fullVacanciesRepo(worker: IRetrofitWorker): IFullVacanciesRepo =
        FullVacanciesRepo(worker)
}