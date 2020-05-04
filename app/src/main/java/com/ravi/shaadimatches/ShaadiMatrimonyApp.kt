package com.ravi.shaadimatches


import com.ravi.shaadimatches.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ShaadiMatrimonyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).baseUrl("https://reqres.in/").build()
    }

}

