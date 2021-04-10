package org.romeo.headhounterclient.main.fragments.filters

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.romeo.headhounterclient.model.entity.filter.Filter
import org.romeo.headhounterclient.model.repo.IFiltersRepo
import org.romeo.headhounterclient.model.repo.ILocationRepo
import org.romeo.headhounterclient.navigation.screens.IScreens
import javax.inject.Inject
import javax.inject.Named

class FiltersPresenter : MvpPresenter<FiltersView>(), IFiltersPresenter {

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var filtersRepo: IFiltersRepo

    @Inject
    lateinit var locationRepo: ILocationRepo

    @Inject
    @field:Named("MAIN")
    lateinit var mainScheduler: Scheduler

    override fun onFirstViewAttach() {
        filtersRepo.getFilter()
            .observeOn(mainScheduler)
            .subscribe({ filter ->
                filter?.let {
                    viewState.setLocationText(filter.location)
                } ?: setCurrentLocation()

            }, { e ->
                setCurrentLocation()
            })
    }

    override fun onPermissionsGranted() {
        locationRepo.getUserCountry().flatMap { country ->
            country?.let {
                filtersRepo.replaceFilter(Filter(country))
            }?.toSingle {
                country
            }
        }.observeOn(mainScheduler)
            .subscribe({ location ->
                viewState.setLocationText(location)
            }, { e ->
                viewState.showMessage(e.message)
            })
    }

    override fun onPermissionsDenied() {
        viewState.showMessage("This app won't work until you grant the location permission")
        viewState.requestLocationPermission()
    }

    override fun onBackPressed(location: String) {
        filtersRepo.replaceFilter(Filter(location))
            .subscribe()

        router.exit()
    }

    override fun onAutoLocatePressed() {
        setCurrentLocation()
    }

    private fun setCurrentLocation() {
        viewState.requestLocationPermission()
    }
}