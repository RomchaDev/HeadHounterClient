package org.romeo.headhounterclient.main.fragments.vacancies

import org.romeo.headhounterclient.base.presenter.IFragmentPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter

interface AbstractVacanciesPresenter : IFragmentPresenter {
    val listPresenter: IVacanciesListPresenter
}