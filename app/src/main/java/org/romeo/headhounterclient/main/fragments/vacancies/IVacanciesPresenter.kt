package org.romeo.headhounterclient.main.fragments.vacancies

import org.romeo.headhounterclient.base.presenter.IFragmentPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter
import org.romeo.headhounterclient.navigation.BackPressedListener

interface IVacanciesPresenter : IFragmentPresenter, BackPressedListener {
    val listPresenter: IVacanciesListPresenter
    fun onSearchPressed(searchText: String): Boolean
}