package org.romeo.headhounterclient.model.image

interface IImageLoader<C> {
    fun loadInto(container: C, url: String)
}