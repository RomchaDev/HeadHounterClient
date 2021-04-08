package org.romeo.headhounterclient.base.list

interface BaseListPresenter<O, I : BaseListItem> {
    val items: List<O>

    fun bind(item: I, pos: Int)

    fun getItemsCount(): Int

    fun resetItems(items: List<O>)

    interface BaseItemClickListener<I> {
        var onClick: (I) -> Unit
    }
}