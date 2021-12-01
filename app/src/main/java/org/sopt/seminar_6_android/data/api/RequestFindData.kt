package org.sopt.seminar_6_android.data.api

import com.google.gson.annotations.SerializedName

data class RequestFindData(
    @SerializedName("id")
    val channelName: String,
    val like: Int,
    val channelDesc: String,
    val createAt: String,
    val friendCount: Int,
    val channelImageUrl: String,
    val articles : Article
) {
    data class Article(
        val id: Int,
        val title: String,
        val writer: String,
        val channelId: Int,
        val isDeleted: Boolean
    )
}
