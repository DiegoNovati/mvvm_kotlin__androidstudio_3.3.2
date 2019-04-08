package com.template.mvvmtemplate.view

import android.databinding.DataBindingUtil
import android.os.Bundle

import com.template.mvvmtemplate.R
import com.template.mvvmtemplate.databinding.ActivityMainBinding
import com.template.mvvmtemplate.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)

            val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            activityMainBinding.setMainViewModel(MainViewModel(this))
        } catch (ex: Exception) {
            logError(ex)
        }

    }
}
