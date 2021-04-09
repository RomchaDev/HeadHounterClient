package org.romeo.headhounterclient.base.list

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface BaseListFragmentView: MvpView {
    fun initList()
    fun updateList()
}