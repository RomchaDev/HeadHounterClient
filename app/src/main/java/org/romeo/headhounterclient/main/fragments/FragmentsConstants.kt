package org.romeo.headhounterclient.main.fragments

import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.getAreaText
import org.romeo.headhounterclient.model.entity.vacancy.getSalaryText
import org.romeo.headhounterclient.model.entity.vacancy.getSnippetText

const val VACANCY_FULL_URL_KEY = "VACANCY_FULL_URL_KEY"

fun processVacancy(
    vacancy: AbstractVacancy,
    viewState: AbstractVacancyView) {

    val salary: String = getSalaryText(vacancy.salary)
    val area = getAreaText(vacancy.area)

    viewState.setName(vacancy.name)
    viewState.setSalary(salary)
    viewState.setArea(area)
}