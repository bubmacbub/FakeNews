package cto.its.ny.gov.fakenews.model

import com.google.gson.annotations.SerializedName

data class Article(@SerializedName("user_name" ) var userName : String? = null,
                   @SerializedName("email"     ) var email    : String? = null,
                   @SerializedName("name"      ) var name     : String? = null)
