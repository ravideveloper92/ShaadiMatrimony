package com.ravi.shaadimatches.data

import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.data.model.ShaadiMatchesResponseModel
import com.ravi.shaadimatches.data.source.local.AppDataBase
import com.ravi.shaadimatches.data.source.network.ApiService
import com.ravi.shaadimatches.util.StateLiveData
import com.ravi.shaadimatches.util.Utility
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject

class DataRepository
@Inject constructor(private val appDataBase : AppDataBase, private val apiService: ApiService) {
    val TAG=DataRepository::class.java.simpleName
    var mStateLiveData: StateLiveData<List<ShaadiMatchesResponseModel>> = StateLiveData()
    private val disposables = CompositeDisposable()
    val shadiMatchesDao=appDataBase.shadiMatchesDao()


    fun onClear() {

    }

    fun getShadiMatchesListFromNetworkOrDb(): StateLiveData<List<ShaadiMatchesResponseModel>>? {
        Utility.printLog(TAG,"getShadiMatchesListFromNetworkOrDb")
        disposables.add( apiService.getMatchesList(10.toString())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<ShaadiMatchesResponseModel?>() {
                override fun onError(e: Throwable) {
                    //Handle error
                    Utility.printLog(TAG,"onError "+ e.toString())
                    Executors.newSingleThreadExecutor().execute({
                        if (shadiMatchesDao.totalCount > 0) {
                            mStateLiveData.postSuccess(shadiMatchesDao.allList)
                        } else {
                            mStateLiveData.postError(e)
                        }
                    })
                }

                override fun onSuccess(t: ShaadiMatchesResponseModel) {
                    Utility.printLog(TAG,"onSuccess "+ t.toString())
                    Executors.newSingleThreadExecutor().execute({
                        val shadiMatchesModelsList: List<ShaadiMatchesModel> = t.getShaadiMatchesModels()
                        if (shadiMatchesModelsList != null && shadiMatchesModelsList.size > 0) {
                            shadiMatchesDao.deleteAll()
                            shadiMatchesDao.insertAll(shadiMatchesModelsList)
                            mStateLiveData.postSuccess(shadiMatchesModelsList)
                        } else {
                            mStateLiveData.postSuccess(shadiMatchesDao.allList)
                        }
                    })

                }
            }))
        return mStateLiveData
    }

    fun updateAccept(item: ShaadiMatchesModel) {
        Executors.newSingleThreadExecutor().execute({
            val email: String = item.getEmail()
            shadiMatchesDao.updateOnAccept(1, email)
            mStateLiveData.postSuccess(shadiMatchesDao.allList)
        })
    }

    fun updateReject(item: ShaadiMatchesModel) {
        Executors.newSingleThreadExecutor().execute({
            val email: String = item.getEmail()
            shadiMatchesDao.updateOnReject(1, email)
            mStateLiveData.postSuccess(shadiMatchesDao.allList)
        })
    }
}