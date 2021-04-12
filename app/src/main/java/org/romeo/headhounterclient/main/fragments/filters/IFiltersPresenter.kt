package org.romeo.headhounterclient.main.fragments.filters

import org.romeo.headhounterclient.main.fragments.location.location_requester.LocationRequestPresenter

interface IFiltersPresenter : LocationRequestPresenter {
    fun onBackPressed(location: String)
    fun onAutoLocatePressed()
}