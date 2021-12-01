package org.sopt.seminar_6_android.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FindInterface {
    /*
    - interface DataSource만들기
    - 내부에 함수는 api문서당 한개씩
        예) fun getkakaolist() : kakaolist
     */
    @GET("")
    fun getFindlist(
        @Query("Id") id : String
    ) : Call<ResponseFindData>
}
