// 15.2.2023
// Leo Koskimäki
// 2201352
// ParlamentApi has a moshi & retrofit for getting and reading
// the json file that comes from the internet.
package com.example.parlament_app

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://users.metropolia.fi/~peterh/"

//Moshi to make json into kotlin
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit to get json from the internet
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//API Service to get MembesOfParliament list
interface ParlamentApiService {
    @GET("seating.json")
    suspend fun  getParlamentList(): List<MemberOfParliament>
}
object ParlamentApi {
    val retrofitService : ParlamentApiService by lazy {
        retrofit.create(ParlamentApiService::class.java) }
}
