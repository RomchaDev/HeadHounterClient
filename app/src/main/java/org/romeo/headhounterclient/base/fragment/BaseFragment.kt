package org.romeo.headhounterclient.base.fragment

import android.os.Bundle
import android.os.Parcelable
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

    companion object {
        inline fun <reified T : BaseFragment<out ViewBinding, out IFragmentPresenter>> createFragment(
            args: Map<String, Parcelable>? = null
        ): MvpAppCompatFragment {
            val fragment = T::class.java.newInstance()
            val bundle = Bundle()

            args?.forEach { pair ->
                bundle.putParcelable(pair.key, pair.value)
            }

            fragment.arguments = bundle

            return fragment
        }
    }
}