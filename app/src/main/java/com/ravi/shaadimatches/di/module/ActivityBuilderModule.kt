package com.ravi.shaadimatches.di.module

import com.ravi.shaadimatches.ui.MainActivity
import com.ravi.shaadimatches.ui.ViewModelFactory
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
