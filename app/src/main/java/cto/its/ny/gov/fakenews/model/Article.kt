package cto.its.ny.gov.fakenews.model

import com.google.gson.annotations.SerializedName


data class Article (

    @SerializedName("source"      ) var source      : Source? = Source(name="Initialized"),
    @SerializedName("author"      ) var author      : String = "Annonymous",
    @SerializedName("title"       ) var title       : String,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("url"         ) var url         : String,
    @SerializedName("urlToImage"  ) var urlToImage  : String? = null,
    @SerializedName("publishedAt" ) var publishedAt : String,
    @SerializedName("content"     ) var content     : String? = null

)
