package org.romeo.headhounterclient.main.fragments.vacancies

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacancyListItem
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter
import org.romeo.headhounterclient.model.entity.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.repo.IShortVacanciesRepo
import javax.inject.Inject
import javax.inject.Named

class VacanciesPresenter : MvpPresenter<VacanciesView>(), IVacanciesPresenter {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var repo: IShortVacanciesRepo

    @Inject
    @field:Named("MAIN")
    lateinit var mainScheduler: Scheduler

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

            val salary: String = vacancy.salary?.run {
                "${(from ?: to)} $currency"
            } ?: ""

            val snippet = ((vacancy.snippet.responsibility
                ?: vacancy.snippet.requirement) ?: "")
                .replace("highlighttext", "b")

            Log.d(TAG, "bind: \n$snippet")

            item.setName(vacancy.name)
            item.setSalary(salary)
            item.setArea(vacancy.area?.name ?: "Remote job")
            item.setSnippet(snippet)
        }

        override fun getItemsCount() = items.size

        override fun resetItems(items: List<VacancyShort>) {
            this.items.clear()
            this.items.addAll(items)
            viewState.updateList()
        }

        override fun onItemClick(item: IVacancyListItem) {
            viewState.updateList()
        }
    }

    companion object {
        private const val TAG = "VACANCIES"
    }
}