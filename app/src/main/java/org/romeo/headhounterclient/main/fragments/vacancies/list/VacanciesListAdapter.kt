package org.romeo.headhounterclient.main.fragments.vacancies.list

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.romeo.headhounterclient.R
import org.romeo.headhounterclient.databinding.VacancyListItemBinding

class VacanciesListAdapter(private val presenter: IVacanciesListPresenter) :
    RecyclerView.Adapter<VacanciesListAdapter.VacanciesViewHolder>() {

    inner class VacanciesViewHolder(private val binding: VacancyListItemBinding) :
        RecyclerView.ViewHolder(binding.root), IVacancyListItem {

        init {
            binding.starImage.setOnClickListener {
                presenter.onStarClicked(this)
            }

            binding.root.setOnClickListener {
                presenter.onItemClick(this)
            }
        }

        override fun setSnippet(text: String) {
            binding.snippet.text = Html.fromHtml(text)
        }

        override fun setStarFilled() {
            binding.starImage.setImageResource(R.drawable.star_filled)
        }

        override fun setStarBorder() {
            binding.starImage.setImageResource(R.drawable.star_border)
        }

        override fun setSalary(text: String) {
            binding.salary.text = text
        }

        override fun setName(text: String) {
            binding.name.text = text
        }

        override fun setArea(text: String) {
            binding.area.text = text
        }

        override val pos: Int
            get() = adapterPosition

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacanciesViewHolder =
        VacanciesViewHolder(
            VacancyListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VacanciesViewHolder, position: Int) {
        presenter.bind(holder, position)
    }

    override fun getItemCount() = presenter.getItemsCount()
}