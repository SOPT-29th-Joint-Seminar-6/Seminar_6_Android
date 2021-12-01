package org.sopt.seminar_6_android.data.api

data class ResponseFindData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {
    data class Data (
        val id: Int,
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
}
