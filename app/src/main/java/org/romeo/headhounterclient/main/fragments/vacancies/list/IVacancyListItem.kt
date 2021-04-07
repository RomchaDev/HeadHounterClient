package org.romeo.headhounterclient.main.fragments.vacancies.list

import org.romeo.headhounterclient.base.list.BaseListItem
import org.romeo.headhounterclient.main.fragments.AbstractVacancyView

interface IVacancyListItem : BaseListItem, AbstractVacancyView {
    fun setSnippet(text: String)
}