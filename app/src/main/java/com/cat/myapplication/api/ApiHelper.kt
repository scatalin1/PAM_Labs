package com.cat.myapplication.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPayments() = apiService.getPayments()
    suspend fun getNotes() = apiService.getNotes()
    suspend fun postNotes(item: Note) = apiService.postNotes(item)
    suspend fun postPayments(item: Model) = apiService.postPayments(item)
}