package org.romeo.headhounterclient.base.list

interface BaseListPresenter<O, I : BaseListItem> {
    val items: MutableList<O>

    fun bind(item: I, pos: Int)

    fun getItemsCount(): Int

    interface BaseItemClickListener<I> {
        var onClick: (I) -> Unit
    }
}