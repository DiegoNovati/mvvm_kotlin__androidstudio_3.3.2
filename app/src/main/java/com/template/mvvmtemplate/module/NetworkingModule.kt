package com.template.mvvmtemplate.module

import android.content.Context

import com.template.mvvmtemplate.R
import com.template.mvvmtemplate.model.RuntimeData
import com.template.mvvmtemplate.service.NetworkingService
import com.template.mvvmtemplate.service.api.NetworkingAPI

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by diegonovati on 18/04/2018.
 */

/**
 * This module creates the NetworkingService class linking the NetworkAPI interface to Retrofit.
 * Note: in the getRetrofit method is defined to use the GSON library to convert json to java; if
 * the backend uses XML, use an XML converter instead.
 */
@Module(includes = [ContextModule::class])
class NetworkingModule {

    private val okHttpClient: OkHttpClient
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

            return OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor).build()
        }

    @Provides
    @Singleton
    fun getNetworkingService(context: Context, runtimeData: RuntimeData): NetworkingService {
        // Note: the base url is defined in the app build.gradle (so that we can have testing and
        // production backend
        val url = context.getString(R.string.restBaseUrl)
        val networkingAPI = getRetrofit(url).create(NetworkingAPI::class.java)
        return NetworkingService(context, networkingAPI, runtimeData)
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // Link between Retrofit 2 and RxJava 2
                .build()
    }
}