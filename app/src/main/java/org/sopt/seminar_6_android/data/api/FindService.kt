package org.sopt.seminar_6_android.data.api

import org.sopt.seminar_6_android.data.model.request.RequestChannelData
import org.sopt.seminar_6_android.data.model.response.ResponseChannelData
import org.sopt.seminar_6_android.data.model.response.ResponseChannelIdData
import org.sopt.seminar_6_android.data.model.response.ResponseFindData
import retrofit2.Call
import retrofit2.http.*

interface FindService {
    @Headers("Content-Type:application/json")

    @GET("view/viewfind")
    fun getFindlist(
        // 헤더나 쿼리
    ) : Call<ResponseFindData>

    @POST("channel")
    fun postChannelList(
        @Body channelData : RequestChannelData
    ) : Call<ResponseChannelData>

    @GET("channel/{id}")
    fun getChannelIdList(
        @Path("id") id: Int
    ) : Call<ResponseChannelIdData>

}