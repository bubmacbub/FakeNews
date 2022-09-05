package cto.its.ny.gov.fakenews.model

import com.google.gson.annotations.SerializedName


data class Article (

    @SerializedName("source"      ) var source      : Source?,
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
        var _title: StringBuilder = StringBuilder();
        var _author = "";
        var _srcName = ""
        if (this.title != null) {
            _title.append("  Title: ")
            _title.append(this.title)
            concatString = concatString.plus(_title.toString())
        }
        if (_author != null) {
            concatString = concatString.plus("  Author: ${author}")
        }
        if (source?.name != null) {
            concatString = concatString + "  Source: " + source?.name
        }
        return concatString
    }
}
