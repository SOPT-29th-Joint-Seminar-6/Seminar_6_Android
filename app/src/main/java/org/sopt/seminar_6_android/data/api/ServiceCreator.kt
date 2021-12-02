package org.sopt.seminar_6_android.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-server-again.cloudfunctions.net/api"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val findService : FindService = retrofit.create(FindService::class.java)
    val kakaoTVService : KakaoTVService = retrofit.create(KakaoTVService::class.java)
}