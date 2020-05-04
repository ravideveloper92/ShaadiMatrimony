package com.ravi.shaadimatches.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ravi.shaadimatches.R
import com.ravi.shaadimatches.base.BaseActivityt
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.databinding.ActivityMainBinding
import com.ravi.shaadimatches.util.StateLiveData
import com.ravi.shaadimatches.util.Utility

class MainActivity : BaseActivityt<MainViewModel, ActivityMainBinding>(), View.OnClickListener {

    val TAG: String = MainActivity::class.java.simpleName
    var mAdapter: ShaadiMatchesListAdapter? = null
    lateinit var binding: ActivityMainBinding
    lateinit var myviewModel: MainViewModel

    override fun onCreate(
        instance: Bundle?,
        viewModel: MainViewModel,
        binding: ActivityMainBinding
    ) {
        Utility.printLog(TAG, "create")
        this.binding = binding
        this.myviewModel = viewModel
        binding.btnRetry.setOnClickListener(this)
        binding.loading = true

        callAPI()

    }

    private fun callAPI() {
        this.myviewModel.shaadiMatchesListLiveData?.observe(this, Observer { listStateLiveData ->
            when (listStateLiveData.status) {
                StateLiveData.DataStatus.LOADING -> binding.loading = true
                StateLiveData.DataStatus.ERROR -> {
                    binding.loading = false
                    binding.loading = null
                    binding.txtNoResult.text = "No Internet"
                    binding.ivNoResult.setImageResource(R.drawable.internet)
                    binding.btnRetry.visibility = View.VISIBLE
                }
                StateLiveData.DataStatus.SUCCESS -> {
                    binding.loading = false
                    if (listStateLiveData.data != null) setShadiMatchesAdapter(
                        listStateLiveData.data,
                        binding
                    )
                }
            }
        })
    }

    private fun setShadiMatchesAdapter(
        matchesList: List<ShaadiMatchesModel>?,
        binding: ActivityMainBinding
    ) {
        Utility.printLog(TAG, "setShadiMatchesAdapter")
        if (mAdapter == null) {
            mAdapter = matchesList?.let {
                ShaadiMatchesListAdapter(
                    this,
                    it as MutableList<ShaadiMatchesModel>, this::onClick
                )
            }
            binding.rvUsers.setLayoutManager(
                LinearLayoutManager(
                    this,
                    RecyclerView.VERTICAL,
                    false
                )
            )
            //  val snapHelper: SnapHelper = PagerSnapHelper()
            // snapHelper.attachToRecyclerView(binding.rvUsers)
            binding.rvUsers.setAdapter(mAdapter)
        } else {
            mAdapter?.setItems(matchesList)
        }
    }

    override val viewModel: Class<MainViewModel>
        get() = MainViewModel::class.java


    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun onClick(view: View?) {
        var item: ShaadiMatchesModel? = null
        if (view?.id == R.id.accept_button || view?.id == R.id.reject_buttuon) {
            item = view?.getTag(R.string.click_tag) as ShaadiMatchesModel
        }
        when (view?.id) {
            R.id.btn_retry -> {
                binding.loading = true
                myviewModel.loadData()
            }
            R.id.accept_button -> {
                Utility.printLog(TAG, "accepted " + item.toString())
                myviewModel.onAccept(item)
            }
            R.id.reject_buttuon -> {
                Utility.printLog(TAG, "reject " + item.toString())
                myviewModel.onReject(item)
            }


        }

    }
}
