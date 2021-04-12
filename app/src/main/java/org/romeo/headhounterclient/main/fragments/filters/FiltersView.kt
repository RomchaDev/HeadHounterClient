package org.romeo.headhounterclient.main.fragments.filters

import moxy.viewstate.strategy.alias.AddToEndSingle
import org.romeo.headhounterclient.base.MessageShower
import org.romeo.headhounterclient.main.fragments.location.location_requester.LocationRequestView
import org.romeo.headhounterclient.navigation.BackPressedListener

@AddToEndSingle
interface FiltersView : LocationRequestView, MessageShower, BackPressedListener {
    fun setLocationText(location: String)
}