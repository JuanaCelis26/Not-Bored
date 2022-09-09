package com.example.notbored.service

import com.example.notbored.model.Activity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
/**
 * The function that makes the request to the API and returns a response of type Activity
 **/
interface APIService {
    @GET
    suspend fun getRequest (@Url url:String) : Response<Activity>
}