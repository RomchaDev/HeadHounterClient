package org.romeo.headhounterclient.main.fragments.vacansy

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.base.fragment.BaseFragment
import org.romeo.headhounterclient.databinding.FragmentVacancyBinding
import org.romeo.headhounterclient.main.fragments.VACANCY_FULL_URL_KEY
import org.romeo.headhounterclient.navigation.App
import org.romeo.headhounterclient.navigation.BackPressedListener

class VacancyFragment :
    BaseFragment<FragmentVacancyBinding, IVacancyPresenter>(),
    VacancyView,
    BackPressedListener {
    override var binding: FragmentVacancyBinding? = null

    override val presenter: IVacancyPresenter
            by moxyPresenter {
                val url = arguments!!.getString(VACANCY_FULL_URL_KEY)!!
                VacancyPresenter(url).apply {
                    App.instance.mainComponent.inject(this)
                }
            }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVacancyBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            binding = this
        }.root

    override fun setLogoByUrl(url: String) {
        Toast.makeText(context, url, Toast.LENGTH_LONG).show()
    }

    override fun setName(text: String) {
        binding?.apply {
            this.name.text = text
        }
    }

    override fun setArea(text: String) {
        binding?.apply {
            this.area.text = text
        }
    }

    override fun setSalary(text: String) {
        binding?.apply {
            this.salary.text = text
        }
    }

    override fun setDescription(description: String) {
        binding?.apply {
            this.description.text = Html.fromHtml(description)
        }
    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun create(vacancyFullUrl: String): VacancyFragment {
            val bundle = Bundle()
            val fragment = VacancyFragment()

            bundle.putString(VACANCY_FULL_URL_KEY, vacancyFullUrl)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}