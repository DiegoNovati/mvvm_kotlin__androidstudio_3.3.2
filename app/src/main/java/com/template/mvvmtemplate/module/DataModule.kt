package com.template.mvvmtemplate.module

import android.content.Context

import com.template.mvvmtemplate.model.RuntimeData

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by diegonovati on 18/04/2018.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun getUserData(context: Context): RuntimeData {
        return RuntimeData(context)
    }
}