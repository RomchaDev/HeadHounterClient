package org.romeo.headhounterclient.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.headhounterclient.main.fragments.filters.FiltersFragment
import org.romeo.headhounterclient.main.fragments.vacancies.favorites.VacanciesFavoritesFragment
import org.romeo.headhounterclient.main.fragments.vacancies.search.VacanciesSearchFragment
import org.romeo.headhounterclient.main.fragments.vacansy.VacancyFragment
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

class Screens : IScreens {
    override fun getFiltersScreen() =
        FragmentScreen { FiltersFragment.create() }

    override fun getVacanciesSearchScreen() =
        FragmentScreen { VacanciesSearchFragment.create() }

    override fun getVacancyScreen(vacancy: VacancyFull) =
        FragmentScreen { VacancyFragment.create(vacancy) }

    override fun getVacanciesFavoritesScreen() =
        FragmentScreen { VacanciesFavoritesFragment.create() }
}