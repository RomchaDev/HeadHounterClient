package org.romeo.headhounterclient.model.entity.vacancy

import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.Snippet

fun getSalaryText(salary: Salary?) =
    salary?.run {
        "${(from ?: to)} $currency"
    } ?: ""

fun getSnippetText(snippet: Snippet) =
    ((snippet.responsibility
        ?: snippet.requirement) ?: "")
        .replace("highlighttext", "b")

fun getAreaText(area: Area?) = area?.name ?: "Remote job"