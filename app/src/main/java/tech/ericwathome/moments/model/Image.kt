package tech.ericwathome.moments.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image(
    val id: String,
    val description: String?,
    @SerializedName("urls") @Expose val size: Size?
)