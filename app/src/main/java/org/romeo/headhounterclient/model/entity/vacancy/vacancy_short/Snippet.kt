package org.romeo.headhounterclient.model.entity.vacancy.vacancy_short

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
class Snippet(
    @Expose val requirement: String?,
    @Expose val responsibility: String?
) : Parcelable