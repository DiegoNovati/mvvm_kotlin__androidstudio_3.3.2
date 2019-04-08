package com.template.mvvmtemplate.service

import android.content.Context

import com.template.mvvmtemplate.model.RuntimeData
import com.template.mvvmtemplate.service.api.NetworkingAPI

/**
 * This class implements the connections with the backend using Retrofit
 */
class NetworkingService(private val context: Context, private val networkingAPI: NetworkingAPI, private val runtimeData: RuntimeData)
