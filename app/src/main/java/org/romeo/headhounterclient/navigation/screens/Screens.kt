package org.romeo.headhounterclient.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.headhounterclient.main.fragments.vacancies.VacanciesFragment
import org.romeo.headhounterclient.main.fragments.vacansy.VacancyFragment

class Screens : IScreens {
    override fun getVacanciesScreen() =
        FragmentScreen { VacanciesFragment.create() }

    override fun getVacancyScreen(url: String) =
        FragmentScreen { VacancyFragment.create(url) }
}