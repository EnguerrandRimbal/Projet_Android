package com.ismin.android

import retrofit2.Call
import retrofit2.http.GET

interface RemarkablePlaceService {
    @GET("/0d8d21037d4ba542976e")
    fun getRemarkablePlaces(): Call<List<RemarkablePlace>>
}