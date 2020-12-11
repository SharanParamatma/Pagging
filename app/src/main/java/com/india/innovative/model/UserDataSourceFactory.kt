package com.india.innovative.model

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class UserDataSourceFactory : DataSource.Factory<Int, User>() {
    val userMutableLiveData = MutableLiveData<UserDataSource>()
    override fun create(): DataSource<Int, User> {
        val userDataSource = UserDataSource()
        userMutableLiveData.postValue(userDataSource)
        return userDataSource
    }
}