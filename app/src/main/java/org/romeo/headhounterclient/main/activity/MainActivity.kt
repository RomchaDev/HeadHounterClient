package org.romeo.headhounterclient.main.activity

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.romeo.headhounterclient.R
import org.romeo.headhounterclient.databinding.ActivityMainBinding
import org.romeo.headhounterclient.navigation.App
import org.romeo.headhounterclient.navigation.BackPressedListener
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.mainComponent.inject(this)
        }.apply { App.instance.mainComponent.inject(this) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.mainComponent.inject(this)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(
            AppNavigator(this, R.id.main_fragment_container)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        val listeners = supportFragmentManager.fragments
            .filter { it is BackPressedListener }
            .map { it as BackPressedListener }

        if (listeners.isNullOrEmpty()) {
            presenter.onBackPressed()
            return
        }

        listeners.forEach { it.onBackPressed() }
    }
}