package org.romeo.headhounterclient.main.fragments.vacancies.search

import moxy.viewstate.strategy.alias.AddToEndSingle
import org.romeo.headhounterclient.base.LoadingListener
import org.romeo.headhounterclient.base.MessageShower
import org.romeo.headhounterclient.base.list.BaseListFragmentView
import org.romeo.headhounterclient.main.fragments.location.location_requester.LocationRequestView
import org.romeo.headhounterclient.navigation.BackPressedListener

@AddToEndSingle
interface VacanciesSearchView : BaseListFragmentView, MessageShower, BackPressedListener,
    LoadingListener, LocationRequestView