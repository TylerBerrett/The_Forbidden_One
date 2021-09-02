package com.tylerb.testapp.data.network

import com.tylerb.testapp.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface DefaultService {

    @GET("{name}")
    suspend fun fetch(@Path("name") name: String): Pokemon

}