package com.ravi.shaadimatches.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravi.shaadimatches.di.annotation.ViewModelKey
import com.ravi.shaadimatches.ui.MainViewModel
import com.ravi.shaadimatches.ui.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@SuppressWarnings("WeakerAccess")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory?): ViewModelProvider.Factory?
}