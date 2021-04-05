package org.romeo.headhounterclient.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.headhounterclient.base.fragment.BaseFragment
import org.romeo.headhounterclient.main.fragments.vacancies.VacanciesFragment

class Screens : IScreens {
    override fun getVacanciesScreen() =
        FragmentScreen { BaseFragment.createFragment<VacanciesFragment>() }
}