package com.ravi.shaadimatches.ui

import androidx.lifecycle.ViewModel
import com.ravi.shaadimatches.data.DataRepository
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.data.model.ShaadiMatchesResponseModel
import com.ravi.shaadimatches.util.StateLiveData
import com.ravi.shaadimatches.util.Utility
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: DataRepository)
    : ViewModel() {
    var shaadiMatchesListLiveData: StateLiveData<List<ShaadiMatchesResponseModel>>? = null
    val TAG=MainViewModel::class.java.simpleName
    init {
        Utility.printLog(TAG,"init")
        loadData()
    }

    public fun loadData() {
        shaadiMatchesListLiveData = repository.getShadiMatchesListFromNetworkOrDb()
    }

    fun onAccept(item: ShaadiMatchesModel?) {
        item?.let { repository.updateAccept(it) }
    }

    fun onReject(item: ShaadiMatchesModel?) {
        item?.let { repository.updateReject(it) }
    }

    override fun onCleared() {
        super.onCleared()
        repository.onClear()
    }
}