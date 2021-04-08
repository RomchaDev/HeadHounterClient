package org.romeo.headhounterclient.base

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ILoadingListener {
    @StateStrategyType(AddToEndSingleStrategy::class, tag = "PROGRESS")
    fun showLoading()

    @StateStrategyType(AddToEndSingleStrategy::class, tag = "PROGRESS")
    fun hideLoading()
}