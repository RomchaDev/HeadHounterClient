package org.romeo.headhounterclient.model.entity.vacancy.vacancy_short

import com.google.gson.annotations.Expose

class Snippet(
    @Expose val requirement: String?,
    @Expose val responsibility: String?
)