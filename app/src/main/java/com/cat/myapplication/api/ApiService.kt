package com.cat.myapplication.api

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("payments")
    suspend fun getPayments(): List<Model>
    @GET("notes")
    suspend fun getNotes(): List<Note>
    @POST("payments")
    suspend fun postPayments(item: Model)
    @POST("notes")
    suspend fun postNotes(item: Note)
}