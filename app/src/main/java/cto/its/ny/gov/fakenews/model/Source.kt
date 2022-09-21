package cto.its.ny.gov.fakenews.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import cto.its.ny.gov.fakenews.util.constants.SourceCategories
import cto.its.ny.gov.fakenews.util.constants.SourceCountries
import cto.its.ny.gov.fakenews.util.constants.SourceLanguages
import kotlinx.parcelize.Parcelize


@Parcelize
data class Source (
    @SerializedName("id"          ) var id          : String? = null,
    @SerializedName("name"        ) var name        : String,
    @SerializedName("description" ) var description : String? = "No Description Available",
    @SerializedName("url"         ) var url         : String? = null,
    @SerializedName("category"    ) var category    : SourceCategories?,
    @SerializedName("language"    ) var language    : SourceLanguages?,
    @SerializedName("country"     ) var country     : SourceCountries? = null

) : Parcelable