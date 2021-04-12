package org.romeo.headhounterclient.main.fragments.vacancies.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.R
import org.romeo.headhounterclient.databinding.FragmentVacanciesSearchBinding
import org.romeo.headhounterclient.main.fragments.location.location_requester.LocationRequestFragment
import org.romeo.headhounterclient.main.fragments.vacancies.list.VacanciesListAdapter
import org.romeo.headhounterclient.navigation.App


class VacanciesSearchFragment :
    LocationRequestFragment<FragmentVacanciesSearchBinding, IVacanciesSearchPresenter>(),
    VacanciesSearchView {

    override var binding: FragmentVacanciesSearchBinding? = null

    override val presenter: IVacanciesSearchPresenter by moxyPresenter {
        VacanciesSearchPresenter().apply {
            App.instance.mainComponent.inject(this)
        }
    }

    private val adapter: VacanciesListAdapter by lazy {
        VacanciesListAdapter(presenter.listPresenter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVacanciesSearchBinding
            .inflate(inflater)
            .apply { binding = this }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.let { binding ->
            binding.toolbar.inflateMenu(R.menu.menu_vacancies_search)
            binding.toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item_search ->
                        presenter.onSearchPressed(
                            binding.searchText.text.toString()
                        )
                    R.id.item_favorites ->
                        presenter.onFavoritesPressed()

                    R.id.item_filters ->
                        presenter.onFiltersPressed()
                    else -> false
                }
            }
        }
    }

    override fun initList() {
        val rv = binding!!.recyclerView
        val manager = LinearLayoutManager(context)
        rv.layoutManager = manager
        rv.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun showLoading() {
        binding!!.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding!!.progressBar.visibility = View.INVISIBLE
    }

    companion object {
        fun create() = VacanciesSearchFragment()
    }
}