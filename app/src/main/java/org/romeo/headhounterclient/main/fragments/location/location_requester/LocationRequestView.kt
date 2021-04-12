package org.romeo.headhounterclient.main.fragments.location.location_requester

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface LocationRequestView : MvpView {
    fun requestLocationPermission()
}