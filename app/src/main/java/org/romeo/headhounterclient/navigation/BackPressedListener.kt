package org.romeo.headhounterclient.navigation

import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface BackPressedListener {
    fun onBackPressed()
}