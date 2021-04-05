package org.romeo.headhounterclient.model.entity

import com.google.gson.annotations.Expose

data class Items(@Expose val items: List<VacancyShort>)