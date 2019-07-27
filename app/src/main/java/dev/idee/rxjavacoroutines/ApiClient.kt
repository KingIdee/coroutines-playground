package dev.idee.rxjavacoroutines

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiClient {

    private var apiService: ApiService? = null

    val client: ApiService
        get() {

            if (apiService == null) {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                apiService = Retrofit.Builder()
                    .baseUrl("https://jobs.github.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(OkHttpClient())
                    .build().create(ApiService::class.java)
            }

            return apiService!!

        }

}