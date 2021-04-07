package org.romeo.headhounterclient.main.fragments.vacansy

import moxy.viewstate.strategy.alias.AddToEndSingle
import org.romeo.headhounterclient.base.MessageShower
import org.romeo.headhounterclient.main.fragments.AbstractVacancyView

@AddToEndSingle
interface VacancyView : MessageShower, AbstractVacancyView {
    fun setLogoByUrl(url: String)
    fun setDescription(description: String)
    fun openUrl(url: String)
}