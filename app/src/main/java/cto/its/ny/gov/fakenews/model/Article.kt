package cto.its.ny.gov.fakenews.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(val author: String? = null, var title: String , var content: String, var description: String? = null, var publishedAt: String , var source: Source , var url: String , var urlToImage: String? = null ) :
    Parcelable
