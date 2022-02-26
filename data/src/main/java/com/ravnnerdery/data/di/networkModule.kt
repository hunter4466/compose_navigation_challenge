package com.ravnnerdery.data.di

import android.util.Log
import com.ravnnerdery.data.networking.ArticlesApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://content.guardianapis.com/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }


    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(StatusCodeInterceptor())
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ArticlesApiService {
        val retrofitService: ArticlesApiService by lazy {
            retrofit.create(ArticlesApiService::class.java)
        }
        return retrofitService
    }
}

class StatusCodeInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
        newRequest.addHeader("api-key", "577bfce0-4f14-4eea-886c-d43749cd1a65")
        val response = chain.proceed(newRequest.build())
        Log.d(javaClass.simpleName, "Status code: " + response.code())
        return response
    }
}