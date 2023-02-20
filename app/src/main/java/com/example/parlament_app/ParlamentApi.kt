package com.example.parlament_app

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://users.metropolia.fi/~peterh/seating.json"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ParlamentApiService {
    @GET("member.json")
    suspend fun  getParlamentList(): List<ParliamentMembersData>
}

object ParlamentApi {
    val retrofitService : ParlamentApiService by lazy {
        retrofit.create(ParlamentApiService::class.java) }
}
