package org.romeo.headhounterclient.main.fragments.vacancies.list

import org.romeo.headhounterclient.base.list.BaseListPresenter

interface IVacancyClickListener :
    BaseListPresenter.BaseItemClickListener<IVacancyListItem> {
        fun onStarClicked(item: IVacancyListItem)
    }