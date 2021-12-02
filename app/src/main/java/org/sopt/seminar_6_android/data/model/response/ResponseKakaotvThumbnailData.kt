package org.sopt.seminar_6_android.data.model.response

data class ResponseKakaotvThumbnailData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<Post>
){
    data class Post(
        val id : Int,
        val title : String,
        val desc : String,
        val thumbnailImageUrl : String,
        val isDeleted : Boolean,
        val videochannelId : Int,
        val videos : List<VideoData>
    ){
        data class VideoData(
            val id : Int,
            val title : String,
            val desc : String,
            val thumbnailImageUrl: String,
            val isDeleted: Boolean,
            val videochannelId: Int
        )
    }
}
