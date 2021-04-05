package org.romeo.headhounterclient.model.entity

import com.google.gson.annotations.Expose

class Snippet(
    @Expose val requirement: String?,
    @Expose val responsibility: String?
)