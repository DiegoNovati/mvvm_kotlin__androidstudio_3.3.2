package com.template.mvvmtemplate.module

import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by diegonovati on 18/04/2018.
 */

@Module
class ContextModule(@get:Provides
                    @get:Singleton
                    val context: Context)
