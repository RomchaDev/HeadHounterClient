package org.romeo.headhounterclient.main.fragments.vacansy

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import org.romeo.headhounterclient.main.fragments.processVacancy
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.repo.IFullVacanciesRepo
import javax.inject.Inject
import javax.inject.Named

class VacancyPresenter(private val vacancy: VacancyFull) :
    MvpPresenter<VacancyView>(), IVacancyPresenter {

    @Inject
    lateinit var repo: IFullVacanciesRepo

    @Inject
    lateinit var router: Router

    @Inject
    @field:Named("MAIN")
    lateinit var mainScheduler: Scheduler

    private var isBrowserOpened = false

    override fun onFirstViewAttach() {
        loadVacancy(vacancy)
    }

    private fun loadVacancy(vacancy: VacancyFull) {
        viewState.setName(vacancy.name)

        processVacancy(vacancy, viewState)

        vacancy.employer.logoUrls?.let {
            viewState.setLogoByUrl(it.big)
        }

        viewState.setDescription(vacancy.description)
    }

    override fun onApplyButtonPressed() {
        viewState.openUrl(vacancy.applyAlternateUrl)
        isBrowserOpened = true
    }

    override fun onBackPressed() {
/*        if (!isBrowserOpened)
            router.exit()
        else
            isBrowserOpened = false*/
        router.exit()
    }
}