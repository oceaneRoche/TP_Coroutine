package com.example.bindingadapter.retrofit



import com.example.bindingadapter.pojo.EtuItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface interface_Retrofit {
    @GET("a854dea6-b046-435a-969b-b5dbc6a1e456")
    //fun getEtudiant(): Call<EtuItem>
    suspend fun getEtudiant(): Response<EtuItem>

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    //fun getAllEtudiants():Call<ArrayList<EtuItem>>
    suspend fun getAllEtudiants(): Response<ArrayList<EtuItem>>
}