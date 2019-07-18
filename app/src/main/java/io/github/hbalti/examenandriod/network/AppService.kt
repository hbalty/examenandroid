package io.github.hbalti.examenandriod.network

import io.github.hbalti.examenandriod.Pair
import io.github.hbalti.examenandriod.Token
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface AppService {
    @GET("5d307d8d320000af57204549")
    fun login(@Query("user") user: String, @Query("pwd") password:String): Call<Token>

    @GET("5d306919320000b057204485")
    fun getData(@Header("Authorization")token:String)
    : Call<ArrayList<Pair>>
}

