package com.apptive.japkor.data.api

import com.apptive.japkor.data.model.PostResponse
import com.apptive.japkor.data.model.SignInRequest
import com.apptive.japkor.data.model.SignInResponse
import com.apptive.japkor.data.model.SignUpRequest
import com.apptive.japkor.data.model.UserData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    // POST 예시
    @POST("https://masil-main.duckdns.org")
    fun signup(@Body body: UserData): Call<PostResponse>

    // 로그인 API
    @POST("sign-in")
    fun signIn(@Body body: SignInRequest): Call<SignInResponse>

    @POST("sign-up")
    fun signUp(@Body body: SignUpRequest): Call<Response<Void>>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://masil-main.duckdns.org") // 서버 URL 입력
    .addConverterFactory(GsonConverterFactory.create()) // JSON 컨버터 추가
    .build()
val apiService = retrofit.create(UserApiService::class.java)
