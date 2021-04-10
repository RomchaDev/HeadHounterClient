package org.romeo.headhounterclient.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

interface IScreens {
    fun getFiltersScreen(): FragmentScreen
    fun getVacanciesSearchScreen(): FragmentScreen
    fun getVacancyScreen(vacancy: VacancyFull): FragmentScreen
    fun getVacanciesFavoritesScreen(): FragmentScreen
}