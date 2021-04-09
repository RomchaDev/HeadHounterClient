package org.romeo.headhounterclient.main.fragments.vacancies

import com.github.terrakok.cicerone.Router
import org.romeo.headhounterclient.main.fragments.vacansy.VacancyView
import org.romeo.headhounterclient.model.repo.IFullVacanciesRepo
import org.romeo.headhounterclient.navigation.screens.Screens

interface IFragmentStarter {
    val router: Router
    val screens: Screens
    val fullRepo: IFullVacanciesRepo
    val viewState: VacancyView
}

fun IFragmentStarter.startVacancyFragment(url: String) {

}