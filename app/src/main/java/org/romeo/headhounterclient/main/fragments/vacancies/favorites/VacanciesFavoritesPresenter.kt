package org.romeo.headhounterclient.main.fragments.vacancies.favorites

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import org.romeo.headhounterclient.dagger.module.MAIN_SCHEDULER_KEY
import org.romeo.headhounterclient.main.fragments.vacancies.list.IVacanciesListPresenter
import org.romeo.headhounterclient.main.fragments.vacancies.list.VacanciesListPresenter
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.repo.IFavoritesRepo
import org.romeo.headhounterclient.navigation.screens.IScreens
import javax.inject.Inject
import javax.inject.Named

class VacanciesFavoritesPresenter : MvpPresenter<VacanciesFavoritesView>(),
    IVacanciesFavoritesPresenter {

    @Inject
    lateinit var router: Router

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
                startVacancyFragment(url)
            }

            onStarClicked = { item ->
                val cur = items[item.pos]

                if (cur.isFavorite)
                    favoritesRepo.deleteFromFavorites(cur)
                        .observeOn(mainScheduler)
                        .subscribe {
                            item.setStarBorder()
                            items.removeAt(item.pos)
                            viewState.updateList()
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
        favoritesRepo.getAllFavoritesShort()
            .observeOn(mainScheduler)
            .subscribe(object : SingleObserver<List<VacancyShort>> {
                override fun onSubscribe(d: Disposable?) {
                    viewState.showLoading()
                }

                override fun onSuccess(t: List<VacancyShort>?) {
                    t?.let { list ->
                        resetListItems(list)
                    }

                    viewState.hideLoading()
                }

                override fun onError(e: Throwable?) {
                    viewState.showMessage(e?.message)
                    viewState.hideLoading()
                }

            })
    }

    private fun resetListItems(items: List<VacancyShort>) {
        listPresenter.items.clear()
        listPresenter.items.addAll(items)
        viewState.updateList()
    }

    private fun startVacancyFragment(url: String) {
        favoritesRepo.getVacancyFullByUrl(url)
            .observeOn(mainScheduler)
            .subscribe(object : SingleObserver<VacancyFull> {
                override fun onSubscribe(d: Disposable?) {
                    viewState.showLoading()
                }

                override fun onSuccess(t: VacancyFull?) {
                    t?.let { vacancy ->
                        router.navigateTo(
                            screens.getVacancyScreen(vacancy)
                        )
                        viewState.hideLoading()
                    }
                }

                override fun onError(e: Throwable?) {
                    viewState.showMessage(e?.message)
                    viewState.hideLoading()
                }
            })
    }

    override fun onBackPressed() {
        router.exit()
    }
}