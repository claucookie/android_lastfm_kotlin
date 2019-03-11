package dev.claucookielabs.search.data.model

import com.google.gson.annotations.SerializedName

class ApiSearchBaseResponse<T>(
    @SerializedName("results") val results: T,
    @SerializedName("opensearch:totalResults") val count: String
)
