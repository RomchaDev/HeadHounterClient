package org.romeo.headhounterclient.main.fragments.vacancies.list

import org.romeo.headhounterclient.base.list.BaseListPresenter
import org.romeo.headhounterclient.model.entity.VacancyShort

interface IVacanciesListPresenter :
    BaseListPresenter<VacancyShort, IVacancyListItem>, IVacancyClickListener