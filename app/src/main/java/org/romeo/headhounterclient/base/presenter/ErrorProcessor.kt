package org.romeo.headhounterclient.base.presenter

interface ErrorProcessor {
    fun processError(e: Throwable)
}