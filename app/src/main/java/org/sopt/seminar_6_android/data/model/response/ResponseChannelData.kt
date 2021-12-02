package org.sopt.seminar_6_android.data.model.response

data class ResponseChannelData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<Data>
) {
    data class Data (
        val userId: Int,
        val channelId: Int,
        val id: Int,
        val channelName: String,
        val like: Int,
        val channelDesc: String,
        val isDeleted: Boolean,
        val createAt: String,
        val friendCount: Int,
        val channelImageUrl: String
    )
}
