package dev.idee.rxjavacoroutines

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/positions.json?description=web")
    fun getWebJobs(@Query("page") page: Int): Single<List<JobModel>>

}