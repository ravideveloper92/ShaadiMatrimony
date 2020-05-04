package com.ravi.shaadimatches.util

import androidx.lifecycle.MutableLiveData
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel

class StateLiveData<T> : MutableLiveData<StateLiveData<T>>() {
    enum class DataStatus {
        SUCCESS, ERROR, LOADING
    }
    var data:List<ShaadiMatchesModel>?=null
    var error:Throwable?=null
    var status:DataStatus?=null

    fun loading(): StateLiveData<T> {
        status = DataStatus.LOADING
        data = null
        error = null
        return this
    }

    fun success(data: List<ShaadiMatchesModel>): StateLiveData<T> {
        status = DataStatus.SUCCESS
        this.data = data
        error = null
        return this
    }

    fun error(error: Throwable): StateLiveData<T> {
        status = DataStatus.ERROR
        data = null
        this.error = error
        return this
    }

    fun setLoading() {
        value = StateLiveData<T>().loading()
    }

    fun postSuccess(data: List<ShaadiMatchesModel>) {
        postValue(StateLiveData<T>().success(data))
    }

    fun postError(throwable: Throwable) {
        postValue(StateLiveData<T>().error(throwable))
    }

}