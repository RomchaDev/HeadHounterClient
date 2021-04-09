package org.romeo.headhounterclient.main.fragments.vacancies.list

import org.romeo.headhounterclient.main.fragments.processVacancy
import org.romeo.headhounterclient.model.entity.vacancy.getSnippetText
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

class VacanciesListPresenter : IVacanciesListPresenter {
    override val items = mutableListOf<VacancyShort>()

    override fun bind(item: IVacancyListItem, pos: Int) {
        val vacancy = items[pos]

        val snippet = getSnippetText(vacancy.snippet)

        processVacancy(vacancy, item)

        item.setSnippet(snippet)

        if (vacancy.isFavorite) item.setStarFilled()
        else item.setStarBorder()
    }

    override fun getItemsCount() = items.size

    override lateinit var onStarClicked: (IVacancyListItem) -> Unit

    override lateinit var onClick: (IVacancyListItem) -> Unit
}