package com.template.mvvmtemplate.viewmodel

import android.content.Context

import com.template.mvvmtemplate.error.ErrorManagement
import com.template.mvvmtemplate.model.RuntimeData
import com.template.mvvmtemplate.module.AppComponent
import com.template.mvvmtemplate.module.DependencyInjector
import com.template.mvvmtemplate.service.NetworkingService

import javax.inject.Inject

/**
 * This viewmodel is the base class for all the viewmodels. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
open class BaseViewModel(protected var context: Context) {

    @Inject
    lateinit var runtimeData: RuntimeData

    @Inject
    lateinit var networkingService: NetworkingService

    init {
        try {
            this.context = context
            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.appComponent)
        } catch (ex: Exception) {
            logError(ex)
        }

    }

    fun logError(throwable: Throwable) {
        ErrorManagement.logError(throwable, context)
    }

    protected fun onInject(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }
}
