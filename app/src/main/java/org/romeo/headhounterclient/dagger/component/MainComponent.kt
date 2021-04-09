package org.romeo.headhounterclient.dagger.component

import dagger.Component
import org.romeo.headhounterclient.dagger.module.*
import org.romeo.headhounterclient.dagger.module.db.DaoModule
import org.romeo.headhounterclient.dagger.module.db.DbModule
import org.romeo.headhounterclient.dagger.module.db.WorkerModule
import org.romeo.headhounterclient.main.activity.MainActivity
import org.romeo.headhounterclient.main.activity.MainPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.search.VacanciesSearchPresenter
import org.romeo.headhounterclient.main.fragments.vacansy.VacancyFragment
import org.romeo.headhounterclient.main.fragments.vacansy.VacancyPresenter
import javax.inject.Singleton

@Component(
    modules = [
        CiceroneModule::class,
        ScreensModule::class,
        AppModule::class,
        ApiModule::class,
        RepoModule::class,
        SchedulersModule::class,
        ImageModule::class,
        DbModule::class,
        DaoModule::class,
        WorkerModule::class
    ]
)
@Singleton
interface MainComponent {
    fun inject(activity: MainActivity)

    fun inject(presenter: MainPresenter)
    fun inject(presenter: VacanciesSearchPresenter)
    fun inject(presenter: VacancyPresenter)

    fun inject(fragment: VacancyFragment)
}