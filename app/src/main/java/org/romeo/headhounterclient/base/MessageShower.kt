package org.romeo.headhounterclient.base

import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface MessageShower {
    fun showMessage(message: String?)
}