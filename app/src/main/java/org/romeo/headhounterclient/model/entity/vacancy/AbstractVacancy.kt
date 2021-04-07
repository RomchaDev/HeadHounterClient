package org.romeo.headhounterclient.model.entity.vacancy

interface AbstractVacancy {
    val name: String
    val area: Area?
    val salary: Salary?
}