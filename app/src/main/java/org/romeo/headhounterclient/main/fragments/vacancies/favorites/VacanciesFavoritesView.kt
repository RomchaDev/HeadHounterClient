package org.romeo.headhounterclient.main.fragments.vacancies.favorites

import org.romeo.headhounterclient.base.LoadingListener
import org.romeo.headhounterclient.base.MessageShower
import org.romeo.headhounterclient.base.list.BaseListFragmentView
import org.romeo.headhounterclient.navigation.BackPressedListener

interface VacanciesFavoritesView : BaseListFragmentView, BackPressedListener, LoadingListener,
    MessageShower