package com.template.mvvmtemplate

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ProcessLifecycleOwner
import android.support.multidex.MultiDexApplication

import com.template.mvvmtemplate.error.ErrorManagement
import com.template.mvvmtemplate.module.DependencyInjector

/**
 * Created by diegonovati on 18/04/2018.
 */

class MVVMTemplateApplication : MultiDexApplication(), LifecycleObserver {

    override fun onCreate() {
        try {
            super.onCreate()

            // Here we will add the code to inject the dependencies
            injectDependencies()

            setupLifecycleListener()
        } catch (ex: Exception) {
            logError(ex)
        }

    }

    /**
     * Method called when the app goes in the foreground. Here we can restore data saved when the App
     * went in the background
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
    }

    /**
     * Method called when the app goes in the background. Here we can persist the runtime data
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground() {
    }

    private fun setupLifecycleListener() {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    private fun injectDependencies() {
        DependencyInjector.initialize(this)
        DependencyInjector.appComponent!!.inject(this)
    }

    private fun logError(throwable: Throwable) {
        ErrorManagement.logError(this, throwable)
    }
}
