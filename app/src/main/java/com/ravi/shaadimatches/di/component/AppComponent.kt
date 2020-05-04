package com.ravi.shaadimatches.di.component

import com.ravi.shaadimatches.ShaadiMatrimonyApp
import android.app.Application
import com.ravi.shaadimatches.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        ApiModule::class
    ]
)
interface AppComponent : AndroidInjector<ShaadiMatrimonyApp> {
     @Component.Builder
     interface Builder {
         @BindsInstance
         fun application(application: Application): Builder

         @BindsInstance // you'll call this when setting up Dagger
         fun baseUrl(@Named("baseUrl") baseUrl: String): Builder

         fun build(): AppComponent

     }
    /*@Component.Builder
    abstract class Builder : AndroidInjector.Builder<ShaadiMatrimonyApp?>()*/
}

