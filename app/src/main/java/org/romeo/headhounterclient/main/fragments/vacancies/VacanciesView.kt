package org.romeo.headhounterclient.main.fragments.vacancies

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import org.romeo.headhounterclient.base.MessageShower
import org.romeo.headhounterclient.navigation.BackPressedListener

@AddToEndSingle
interface VacanciesView : MvpView, MessageShower, BackPressedListener {
    fun initList()
    fun updateList()
}