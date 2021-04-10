package org.romeo.headhounterclient.main.fragments.location.location_permission_requester

import org.romeo.headhounterclient.base.presenter.IFragmentPresenter

interface LocationRequestPresenter : IFragmentPresenter {
    fun onPermissionsGranted()
    fun onPermissionsDenied()
}