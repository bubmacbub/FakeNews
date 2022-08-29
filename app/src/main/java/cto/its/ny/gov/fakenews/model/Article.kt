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


) {
    override fun toString(): String {
        var concatString: String = ""
        var title: StringBuilder = StringBuilder();
        var author = "";
        var srcName = ""
        if (title != null) {
            title.append("  Title: ")
            title.append((title))
            concatString = concatString.plus(title.toString())
        }
        if (author != null) {
            concatString = concatString.plus("  Author: ${author}")
        }
        if (source?.name != null) {
            concatString = concatString + "  Source: " + source?.name
        }
        return concatString
    }
}
