package com.example.design_log.data.https

import com.example.design_log.data.https.model.NewTask
import com.example.design_log.data.https.model.TasksResponse
import com.example.design_log.data.https.model.Token
import com.example.design_log.data.https.model.UserCreate
import com.example.design_log.data.https.model.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @POST("user/create")
    fun userCreate(@Body userCreate: UserCreate): Call<Token>

    @POST("user/login")
    fun userLogin(@Body userLogin: UserLogin): Call<Token>

    @GET("todos")
    fun getTasks(
        @Header("Authorization") token: String
    ): Call<List<TasksResponse>>

    @POST("todos")
    fun createNewTask(
        @Body text: NewTask,
        @Header("Authorization") token: String
    ): Call<Unit>

    @PUT("todos/mark")
    fun successTask(
        @Query("id") id: Int,
        @Header("Authorization") token: String
    ): Call<Unit>

    @DELETE("todos/{id}")
    fun deleteTask(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): Call<Unit>
}
