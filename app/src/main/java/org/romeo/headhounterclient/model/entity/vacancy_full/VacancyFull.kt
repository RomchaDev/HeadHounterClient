package org.romeo.headhounterclient.model.entity.vacancy_full

data class VacancyFull(
    val name: String,
    val description: String,
    val employer: Employer,
    val publishedAt: String,
    val applyAlternativeUrl: String,
    val alternativeUrl: String,
    val schedule: Schedule
)