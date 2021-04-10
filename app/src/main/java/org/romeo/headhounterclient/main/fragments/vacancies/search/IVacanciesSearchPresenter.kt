package org.romeo.headhounterclient.main.fragments.vacancies.search

import org.romeo.headhounterclient.main.fragments.location.location_permission_requester.LocationRequestPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.AbstractVacanciesPresenter
import org.romeo.headhounterclient.navigation.BackPressedListener

interface IVacanciesSearchPresenter :
    AbstractVacanciesPresenter,
    LocationRequestPresenter,
    BackPressedListener {

    fun onSearchPressed(searchText: String): Boolean
    fun onFavoritesPressed(): Boolean
    fun onFiltersPressed(): Boolean
}