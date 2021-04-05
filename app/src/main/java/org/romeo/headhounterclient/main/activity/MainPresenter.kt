package org.romeo.headhounterclient.main.activity

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.headhounterclient.navigation.screens.IScreens
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>(), IMainPresenter {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        router.navigateTo(screens.getVacanciesScreen())
    }

    override fun onBackPressed() {
        router.exit()
    }
}