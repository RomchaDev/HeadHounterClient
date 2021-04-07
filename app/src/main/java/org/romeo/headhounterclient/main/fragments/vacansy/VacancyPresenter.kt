package org.romeo.headhounterclient.main.fragments.vacansy

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.romeo.headhounterclient.main.fragments.processVacancy
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.repo.IFullVacanciesRepo
import javax.inject.Inject
import javax.inject.Named

class VacancyPresenter(private val vacancyFullUrl: String) :
    MvpPresenter<VacancyView>(), IVacancyPresenter {

    @Inject
    lateinit var repo: IFullVacanciesRepo

    @Inject
    lateinit var router: Router

    @Inject
    @field:Named("MAIN")
    lateinit var mainScheduler: Scheduler

    private lateinit var vacancyFull: VacancyFull
    private var isBrowserOpened = false

    override fun onFirstViewAttach() {
        repo.getVacancyByUrl(vacancyFullUrl)
            .observeOn(mainScheduler)
            .subscribe(
                { vacancy ->
                    vacancyFull = vacancy
                    loadVacancy(vacancyFull)
                }, { e ->
                    viewState.showMessage(e.message)
                    router.exit()
                }
            )
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
        viewState.openUrl(vacancyFull.applyAlternateUrl)
        isBrowserOpened = true
    }

    override fun onBackPressed() {
        if (!isBrowserOpened)
            router.exit()
        else
            isBrowserOpened = false
    }
}