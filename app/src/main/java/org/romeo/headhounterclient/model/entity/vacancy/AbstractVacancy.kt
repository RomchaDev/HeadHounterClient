package org.romeo.headhounterclient.model.entity.vacancy

import android.os.Parcelable

interface AbstractVacancy {
    val name: String
    val area: Area?
    val salary: Salary?
}