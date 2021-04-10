package org.romeo.headhounterclient.main.fragments.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.databinding.FragmentFiltersBinding
import org.romeo.headhounterclient.main.fragments.location.location_permission_requester.LocationRequestFragment
import org.romeo.headhounterclient.navigation.App

class FiltersFragment :
    LocationRequestFragment<FragmentFiltersBinding, IFiltersPresenter>(), FiltersView {
    override var binding: FragmentFiltersBinding? = null

    override val presenter: IFiltersPresenter
            by moxyPresenter {
                FiltersPresenter().apply {
                    App.instance.mainComponent.inject(this)
                }
            }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentFiltersBinding
            .inflate(inflater)
            .apply { binding = this }
            .root

    override fun onStart() {
        super.onStart()
        binding!!.autoLocateButton.setOnClickListener {
            presenter.onAutoLocatePressed()
        }
    }

    override fun setLocationText(location: String) {
        binding!!.locationText.setText(location)
    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        presenter.onBackPressed(binding!!.locationText.text.toString())
    }

    companion object {
        fun create() = FiltersFragment()
    }
}