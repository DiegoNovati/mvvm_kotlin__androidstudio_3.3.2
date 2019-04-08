package com.template.mvvmtemplate.module

import com.template.mvvmtemplate.MVVMTemplateApplication

object DependencyInjector {

    var appComponent: AppComponent? = null
        private set
        get

    fun initialize(mvvmTemplateApplication: MVVMTemplateApplication) {
        appComponent = DaggerAppComponent
                .builder()
                .contextModule(ContextModule(mvvmTemplateApplication))
                .build()
    }

}
