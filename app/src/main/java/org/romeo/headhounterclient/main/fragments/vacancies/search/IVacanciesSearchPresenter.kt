package org.romeo.headhounterclient.main.fragments.vacancies.search

import org.romeo.headhounterclient.main.fragments.vacancies.AbstractVacanciesPresenter
import org.romeo.headhounterclient.navigation.BackPressedListener

interface IVacanciesSearchPresenter : AbstractVacanciesPresenter, BackPressedListener {
    fun onSearchPressed(searchText: String): Boolean
}