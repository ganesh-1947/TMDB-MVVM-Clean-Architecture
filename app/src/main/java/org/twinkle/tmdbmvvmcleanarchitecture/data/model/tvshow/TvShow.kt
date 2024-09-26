package org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tv_shows")
data class TvShow(

    @ColumnInfo(name = "tv_show_first_air_date")
    @SerializedName("first_air_date")
    val firstAirDate: String?,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "tv_show_name")
    @SerializedName("name")
    val name: String?,

    @ColumnInfo(name = "tv_show_overview")
    @SerializedName("overview")
    val overview: String?,

    @ColumnInfo(name = "tv_show_poster_path")
    @SerializedName("poster_path")
    val posterPath: String?

)