package org.romeo.headhounterclient.dagger.component

import dagger.Component
import org.romeo.headhounterclient.dagger.module.*
import org.romeo.headhounterclient.main.activity.IMainPresenter
import org.romeo.headhounterclient.main.activity.MainActivity
import org.romeo.headhounterclient.main.activity.MainPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.IVacanciesPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.VacanciesPresenter
import javax.inject.Singleton

@Component(
    modules = [
        CiceroneModule::class,
        ScreensModule::class,
        AppModule::class,
        ApiModule::class,
        RepoModule::class,
        SchedulersModule::class
    ]
)
@Singleton
interface MainComponent {
    fun inject(activity: MainActivity)

    fun inject(presenter: MainPresenter)
    fun inject(presenter: VacanciesPresenter)
}