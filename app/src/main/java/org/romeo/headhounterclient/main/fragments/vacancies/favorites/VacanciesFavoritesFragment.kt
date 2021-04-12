package org.romeo.headhounterclient.main.fragments.vacancies.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.R
import org.romeo.headhounterclient.base.fragment.BaseFragment
import org.romeo.headhounterclient.databinding.FragmentVacanciesFavoritesBinding
import org.romeo.headhounterclient.main.fragments.vacancies.list.VacanciesListAdapter
import org.romeo.headhounterclient.navigation.App

class VacanciesFavoritesFragment :
    BaseFragment<FragmentVacanciesFavoritesBinding, IVacanciesFavoritesPresenter>(),
    VacanciesFavoritesView {

    override var binding: FragmentVacanciesFavoritesBinding? = null

    private val adapter: VacanciesListAdapter by lazy {
        VacanciesListAdapter(presenter.listPresenter)
    }

    override val presenter: IVacanciesFavoritesPresenter
            by moxyPresenter {
                VacanciesFavoritesPresenter().apply {
                    App.instance.mainComponent.inject(this)
                }
            }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVacanciesFavoritesBinding
            .inflate(inflater)
            .apply { binding = this }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            toolbar.inflateMenu(R.menu.back_arrow_menu)
            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item_back -> {
                        presenter.onBackPressed()
                        true
                    }

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

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun showLoading() {
        binding!!.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding!!.progressBar.visibility = View.INVISIBLE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun create() = VacanciesFavoritesFragment()
    }
}