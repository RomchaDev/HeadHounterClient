package org.romeo.headhounterclient.main.fragments

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AbstractVacancyView : MvpView {
    fun setSalary(text: String)
    fun setName(text: String)
    fun setArea(text: String)
}