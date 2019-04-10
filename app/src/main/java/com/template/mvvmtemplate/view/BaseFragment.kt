package com.template.mvvmtemplate.view

import android.os.Bundle
import android.support.v4.app.Fragment

import com.template.mvvmtemplate.error.ErrorManagement
import com.template.mvvmtemplate.model.RuntimeData
import com.template.mvvmtemplate.module.AppComponent
import com.template.mvvmtemplate.module.DependencyInjector
import com.template.mvvmtemplate.service.NetworkingService

import javax.inject.Inject

/**
 * This fragment is the base class for all the fragments. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
class BaseFragment : Fragment() {

    @Inject
    lateinit var runtimeData: RuntimeData

    @Inject
    lateinit var networkingService: NetworkingService

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        try {
            super.onActivityCreated(savedInstanceState)

            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.appComponent)
        } catch (ex: Exception) {
            logError(ex)
        }

    }

    fun logError(throwable: Throwable) {
        ErrorManagement.logError(throwable)
    }

    protected fun onInject(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }
}
