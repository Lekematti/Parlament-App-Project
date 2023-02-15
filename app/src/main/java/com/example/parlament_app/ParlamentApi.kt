package com.example.parlament_app

private const val BASE_URL = "https://users.metropolia.fi/~peterh/seating.json"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ParlamentApiService {
    ("member.json")
    suspend fun  getParlamentList(): List<Parlament>
}

object ParlamentApi {
    val retrofitService : ParlamentApiService by lazy {
        retrofit.create(ParlamentApiService::class.java) }
}
