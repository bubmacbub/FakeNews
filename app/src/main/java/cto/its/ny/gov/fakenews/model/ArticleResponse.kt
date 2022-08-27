package cto.its.ny.gov.fakenews.model

import com.google.gson.annotations.SerializedName


data class ArticleResponse (

    @SerializedName("status"       ) var status       : String?             = null,
    @SerializedName("totalResults" ) var totalResults : Int?                = null,
    @SerializedName("articles"     ) var articles     : ArrayList<Article> = arrayListOf()

)