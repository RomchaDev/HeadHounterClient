package org.romeo.headhounterclient.dagger.component

import dagger.Component
import org.romeo.headhounterclient.dagger.module.*
import org.romeo.headhounterclient.main.activity.IMainPresenter
import org.romeo.headhounterclient.main.activity.MainActivity
import org.romeo.headhounterclient.main.activity.MainPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.IVacanciesPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.VacanciesPresenter
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
        ImageModule::class
    ]
)
@Singleton
interface MainComponent {
    fun inject(activity: MainActivity)

    fun inject(presenter: MainPresenter)
    fun inject(presenter: VacanciesPresenter)
    fun inject(presenter: VacancyPresenter)

    fun inject(fragment: VacancyFragment)
}