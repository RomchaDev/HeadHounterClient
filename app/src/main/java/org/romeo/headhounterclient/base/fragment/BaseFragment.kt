package org.romeo.headhounterclient.base.fragment

import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment
import org.romeo.headhounterclient.base.presenter.IFragmentPresenter

abstract class BaseFragment<B : ViewBinding, P: IFragmentPresenter> : MvpAppCompatFragment() {
    protected abstract var binding: B?
    protected abstract val presenter: P

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}