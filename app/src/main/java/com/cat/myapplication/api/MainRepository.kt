package com.cat.myapplication.api

import com.cat.myapplication.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getPayments() = apiHelper.getPayments()
    suspend fun postNotes(item: Note) = apiHelper.postNotes(item)
    suspend fun postPayments(item: Model) = apiHelper.postPayments(item)
    suspend fun getNotes() = apiHelper.getNotes()
}