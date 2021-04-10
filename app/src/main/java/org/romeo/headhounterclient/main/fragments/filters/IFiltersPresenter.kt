package org.romeo.headhounterclient.main.fragments.filters

import org.romeo.headhounterclient.base.presenter.IFragmentPresenter
import org.romeo.headhounterclient.main.fragments.location.location_permission_requester.LocationRequestPresenter
import org.romeo.headhounterclient.navigation.BackPressedListener

interface IFiltersPresenter : LocationRequestPresenter {
    fun onBackPressed(location: String)
    fun onAutoLocatePressed()
}