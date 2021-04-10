package org.romeo.headhounterclient.main.fragments.location

import android.Manifest
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.repo.ILocationRepo
import java.util.*


class AndroidLocationManager(
    private val context: Context
) : ILocationRepo {

    override fun getUserCountry(): Single<String?> =
        Single.fromCallable {
            getCountryName()
        }


    private fun getCountryName(): String? {
        val locationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager

        val providers = locationManager.getProviders(true)

        val isFineGranted = context.checkSelfPermission(
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val isCoarseGranted = context.checkSelfPermission(
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!isFineGranted || !isCoarseGranted) throw IllegalStateException()

        var bestLocation: Location? = null

        for (provider in providers) {
            val l = locationManager.getLastKnownLocation(provider)
            l ?: continue

            if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                bestLocation = l
            }
        }

        val coder = Geocoder(context, Locale(Locale.ENGLISH.language))

        return bestLocation?.let { location ->
            coder.getFromLocation(location.latitude, location.longitude, 1)[0].countryName
        }
    }
}