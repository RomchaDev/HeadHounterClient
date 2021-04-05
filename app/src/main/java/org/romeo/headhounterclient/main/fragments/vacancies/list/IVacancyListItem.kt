package org.romeo.headhounterclient.main.fragments.vacancies.list

import org.romeo.headhounterclient.base.list.BaseListItem
import org.romeo.headhounterclient.model.entity.VacancyShort

interface IVacancyListItem : BaseListItem {
    fun setSnippet(text: String)
    fun setSalary(text: String)
    fun setName(text: String)
    fun setArea(text: String)
}