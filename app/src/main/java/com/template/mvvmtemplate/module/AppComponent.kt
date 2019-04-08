package com.template.mvvmtemplate.module

import com.template.mvvmtemplate.MVVMTemplateApplication
import com.template.mvvmtemplate.view.BaseActivity
import com.template.mvvmtemplate.view.BaseFragment
import com.template.mvvmtemplate.viewmodel.BaseViewModel

import javax.inject.Singleton

import dagger.Component

/**
 * Created by diegonovati on 18/04/2018.
 */

@Singleton
@Component(modules = [NetworkingModule::class, DataModule::class])
interface AppComponent {

    fun inject(mvvmTemplateApplication: MVVMTemplateApplication)

    fun inject(activity: BaseActivity)

    fun inject(fragment: BaseFragment)

    fun inject(viewModel: BaseViewModel)
}
