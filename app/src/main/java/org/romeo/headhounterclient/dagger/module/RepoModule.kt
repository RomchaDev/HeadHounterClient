package org.romeo.headhounterclient.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.api.IRetrofitWorker
import org.romeo.headhounterclient.model.repo.*
import org.romeo.headhounterclient.model.room.db_workers.IFiltersDbWorker
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesFullDbWorker
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesShortDbWorker
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun shortVacanciesRepo(worker: IRetrofitWorker, repo: IFavoritesRepo): IShortVacanciesRepo =
        ShortVacanciesApiRepo(worker, repo)

    @Provides
    @Singleton
    fun fullVacanciesRepo(worker: IRetrofitWorker): IFullVacanciesRepo =
        FullVacanciesApiRepo(worker)

    @Provides
    @Singleton
    fun favoritesRepo(
        repo: IFullVacanciesRepo,
        shortWorker: IVacanciesShortDbWorker,
        fullWorker: IVacanciesFullDbWorker
    ): IFavoritesRepo =
        FavoritesRepo(
            repo = repo,
            shortWorker = shortWorker,
            fullWorker = fullWorker
        )

    @Provides
    @Singleton
    fun filtersRepo(worker: IFiltersDbWorker): IFiltersRepo =
        FiltersRepo(worker)
}