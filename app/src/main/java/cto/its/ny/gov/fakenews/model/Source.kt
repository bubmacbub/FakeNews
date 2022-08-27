package cto.its.ny.gov.fakenews.model

import com.google.gson.annotations.SerializedName


data class Source (
    @SerializedName("id"          ) var id          : String? = null,
    @SerializedName("name"        ) var name        : String,
    @SerializedName("description" ) var description : String? = "No Description Available",
    @SerializedName("url"         ) var url         : String? = null,
    @SerializedName("category"    ) var category    : String? = "No associated category",
    @SerializedName("language"    ) var language    : String? = "For some reason this language is unknown",
    @SerializedName("country"     ) var country     : String? = null

)