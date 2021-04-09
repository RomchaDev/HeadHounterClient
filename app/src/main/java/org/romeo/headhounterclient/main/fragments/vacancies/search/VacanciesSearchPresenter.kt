package org.romeo.headhounterclient.main.fragments.vacancies.search

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.romeo.headhounterclient.dagger.module.MAIN_SCHEDULER_KEY
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.list.VacanciesListPresenter
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.repo.IFavoritesRepo
import org.romeo.headhounterclient.model.repo.IShortVacanciesRepo
import org.romeo.headhounterclient.navigation.screens.IScreens
import javax.inject.Inject
import javax.inject.Named

class VacanciesSearchPresenter : MvpPresenter<VacanciesSearchView>(), IVacanciesSearchPresenter {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var shortVacanciesRepo: IShortVacanciesRepo

    @Inject
    @field:Named(MAIN_SCHEDULER_KEY)
    lateinit var mainScheduler: Scheduler

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var favoritesRepo: IFavoritesRepo

    override val listPresenter: IVacanciesListPresenter =
        VacanciesListPresenter().apply {
            onClick = { item ->
                val url = items[item.pos].url
                router.navigateTo(screens.getVacancyScreen(url))
            }

            onStarClicked = { item ->
                val cur = items[item.pos]

                if (cur.isFavorite)
                    favoritesRepo.deleteFromFavorites(cur)
                        .observeOn(mainScheduler)
                        .subscribe {
                            item.setStarBorder()
                        }
                else {
                    favoritesRepo.addToFavorites(cur)
                        .observeOn(mainScheduler)
                        .subscribe {
                            item.setStarFilled()
                        }
                }

                cur.isFavorite = !cur.isFavorite
            }
        }

    override fun onFirstViewAttach() {
        viewState.initList()
    }

    override fun onSearchPressed(searchText: String): Boolean {
        viewState.showLoading()
        shortVacanciesRepo.getVacanciesSingleBySearch(searchText)
            .observeOn(mainScheduler)
            .subscribe({ list ->
                resetListItems(list)
                viewState.hideLoading()
            }, { e ->
                e.printStackTrace()
                viewState.showMessage(e.message)
                viewState.hideLoading()
            })
        return true
    }

    override fun onBackPressed() {
        router.exit()
    }

    private fun resetListItems(items: List<VacancyShort>) {
        listPresenter.items.clear()
        listPresenter.items.addAll(items)
        viewState.updateList()
    }
}