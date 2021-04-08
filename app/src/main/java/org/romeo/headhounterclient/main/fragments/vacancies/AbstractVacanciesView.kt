package org.romeo.headhounterclient.main.fragments.vacancies

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AbstractVacanciesView: MvpView {
    fun initList()
    fun updateList()
}