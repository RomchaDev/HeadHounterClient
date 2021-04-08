package org.romeo.headhounterclient.base

import moxy.viewstate.strategy.alias.AddToEndSingle

interface MessageShower {
    @AddToEndSingle
    fun showMessage(message: String?)
}