package dev.vic.retrofit.common

import dev.vic.retrofit.`interface`.RetrofitService
import dev.vic.retrofit.retrofit.RetrofitClient

object Common {
    private var BASE_URL = "http://simplifiedcoding.net/demos/"
    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}