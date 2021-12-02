package org.sopt.seminar_6_android.data.api

import org.sopt.seminar_6_android.data.model.response.ResponseKakaotvThumbnailData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface KakaoTVService {
    @Headers("Content-Type:application/json")
    @GET("/view/viewthumb")
    fun getVideoList(
    ) : Call<ResponseKakaotvThumbnailData>
}