package com.template.mvvmtemplate.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.template.mvvmtemplate.error.ErrorManagement
import com.template.mvvmtemplate.model.RuntimeData
import com.template.mvvmtemplate.module.AppComponent
import com.template.mvvmtemplate.module.DependencyInjector
import com.template.mvvmtemplate.service.NetworkingService

import javax.inject.Inject

/**
 * This activity is the base class for all the activies. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var runtimeData: RuntimeData

    @Inject
    lateinit var networkingService: NetworkingService

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)

            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.appComponent)
        } catch (ex: Exception) {
            logError(ex)
        }

    }

    fun logError(throwable: Throwable) {
        ErrorManagement.logError(this, throwable)
    }

    protected fun onInject(appComponent: AppComponent?) {
        appComponent?.inject(this)
    }
}
