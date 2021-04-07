package org.romeo.headhounterclient.main.fragments.vacancies

import android.R.attr.numColumns
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.R
import org.romeo.headhounterclient.base.fragment.BaseFragment
import org.romeo.headhounterclient.base.presenter.IFragmentPresenter
import org.romeo.headhounterclient.databinding.FragmentVacanciesBinding
import org.romeo.headhounterclient.main.fragments.vacancies.list.VacanciesListAdapter
import org.romeo.headhounterclient.navigation.App


class VacanciesFragment :
    BaseFragment<FragmentVacanciesBinding, IFragmentPresenter>(),
    VacanciesView {

    override var binding: FragmentVacanciesBinding? = null

    override val presenter: IVacanciesPresenter by moxyPresenter {
        VacanciesPresenter().apply {
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
        FragmentVacanciesBinding
            .inflate(inflater)
            .apply { binding = this }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.let { binding ->
            binding.toolbar.inflateMenu(R.menu.menu_vacancies)
            binding.toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item_search ->
                        presenter.onSearchPressed(
                            binding.searchText.text.toString()
                        )

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

    companion object {
        fun create() = VacanciesFragment()
    }
}