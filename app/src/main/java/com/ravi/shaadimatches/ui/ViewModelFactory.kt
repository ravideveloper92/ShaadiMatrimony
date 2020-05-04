package com.ravi.shaadimatches.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory
    @Inject constructor(val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T?>): T {
        var creator: Provider<out ViewModel?>? = viewModelMap[modelClass]
        if (creator == null) {
            for ((key, value) in viewModelMap) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class $modelClass" }
        return try {
            creator.get()
        } catch (e: Exception) {
            throw RuntimeException(e)
        } as T
    }


}

/*
class ViewModelFactory
@Inject
constructor(val viewModelMap : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelMap[modelClass]!!.get() as T
    }

}
*/

/*@Singleton
class ViewModelFactory
@Inject
constructor( val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModelMap[modelClass]
            ?: viewModelMap.entries.first { modelClass.isAssignableFrom(it.key) }.value

        return provider.get() as T
    }
}*/

/*

class ViewModelFactory
@Inject
constructor(val viewModelMap : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelMap[modelClass]!!.get() as T
    }

}*/
