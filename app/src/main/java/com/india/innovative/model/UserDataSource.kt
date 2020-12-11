package com.india.innovative.model

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import com.india.innovative.helperClass.ApiRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDataSource : PageKeyedDataSource<Int,User>() {
    private val scope= CoroutineScope(Dispatchers.Default)
    private var apiClient = ApiRequest()
    @SuppressLint("CommitPrefEdits")
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        scope.launch {
            val response=apiClient.getClient().getUsersData(params.key)
            if (response.isSuccessful){
                val apiResponse = response.body()!!
                val responseItems = apiResponse.users
                val key = if (params.key > 1) params.key - 1 else 0
                 responseItems?.let {
                    callback.onResult(responseItems, key)
                }
            }
        }
    }
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        scope.launch {
            val response=apiClient.getClient().getUsersData(FIRST_PAGE)
            if (response.isSuccessful){
                val apiResponse = response.body()!!
                val responseItems = apiResponse.users
                responseItems?.let {
                    callback.onResult(responseItems, null, FIRST_PAGE + 1)

                }
            }
        }
    }
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        scope.launch {
            val response=apiClient.getClient().getUsersData(params.key)
            if (response.isSuccessful){
                val apiResponse = response.body()!!
                val responseItems = apiResponse.users
                val key = params.key + 1
                responseItems?.let {
                    callback.onResult(responseItems, key)

                }
            }
        }
    }

    companion object {
        const val PAGE_SIZE = 6
        const val FIRST_PAGE = 1
    }


}