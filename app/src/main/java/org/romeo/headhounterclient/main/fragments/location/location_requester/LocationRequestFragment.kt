package org.romeo.headhounterclient.main.fragments.location.location_requester

import android.Manifest
import android.content.pm.PackageManager
import androidx.viewbinding.ViewBinding
import org.romeo.headhounterclient.base.fragment.BaseFragment
import org.romeo.headhounterclient.main.fragments.filters.FiltersFragment

abstract class LocationRequestFragment<B : ViewBinding, P : LocationRequestPresenter> :
    BaseFragment<B, P>(), LocationRequestView {

    override fun requestLocationPermission() {
        val isFineGranted = context!!.checkSelfPermission(
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val isCoarseGranted = context!!.checkSelfPermission(
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val permissions = mutableListOf<String>()

        if (!isFineGranted)
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)

        if (!isCoarseGranted)
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)

        if (permissions.isEmpty())
            presenter.onPermissionsGranted()
        else
            requestPermissions(
                permissions.toTypedArray(),
                LOCATION_PERMISSION_REQUEST_CODE
            )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (
            requestCode == LOCATION_PERMISSION_REQUEST_CODE &&
            grantResults.size == 2 &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED &&
            grantResults[1] == PackageManager.PERMISSION_GRANTED
        ) presenter.onPermissionsGranted()
        else
            presenter.onPermissionsDenied()
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1

        fun create() = FiltersFragment()
    }
}