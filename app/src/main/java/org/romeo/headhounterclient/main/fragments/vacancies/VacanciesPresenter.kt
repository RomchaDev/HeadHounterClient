package org.romeo.headhounterclient.main.fragments.vacancies

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.romeo.headhounterclient.dagger.module.MAIN_SCHEDULER_KEY
import org.romeo.headhounterclient.main.fragments.processVacancy
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacancyListItem
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter
import org.romeo.headhounterclient.model.entity.vacancy.getSnippetText
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.repo.IShortVacanciesRepo
import org.romeo.headhounterclient.navigation.screens.IScreens
import javax.inject.Inject
import javax.inject.Named

class VacanciesPresenter : MvpPresenter<VacanciesView>(), IVacanciesPresenter {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var repo: IShortVacanciesRepo

    @Inject
    @field:Named(MAIN_SCHEDULER_KEY)
    lateinit var mainScheduler: Scheduler

    @Inject
    lateinit var screens: IScreens

    override val listPresenter: IVacanciesListPresenter = VacanciesListPresenter()

    override fun onFirstViewAttach() {
        viewState.initList()
    }

    override fun onSearchPressed(searchText: String): Boolean {
        repo.getVacanciesSingleBySearch(searchText)
            .observeOn(mainScheduler)
            .subscribe({ list ->
                listPresenter.resetItems(list)
            }, { e ->
                e.printStackTrace()
                viewState.showMessage(e.message)
            })

        return true
    }

    override fun onBackPressed() {
        router.exit()
    }

    inner class VacanciesListPresenter : IVacanciesListPresenter {
        override val items = mutableListOf<VacancyShort>()

        override fun bind(item: IVacancyListItem, pos: Int) {
            val vacancy = items[pos]

            val snippet = getSnippetText(vacancy.snippet)

            processVacancy(vacancy, item)

            item.setSnippet(snippet)
        }

        override fun getItemsCount() = items.size

        override fun resetItems(items: List<VacancyShort>) {
            this.items.clear()
            this.items.addAll(items)
            viewState.updateList()
        }

        override fun onItemClick(item: IVacancyListItem) {
            val url = items[item.pos].url
            router.navigateTo(screens.getVacancyScreen(url))
        }
    }
}