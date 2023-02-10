package com.example.app.`view-model`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private val isLogin = MutableLiveData<Boolean>(false)

    fun toggle() {
        isLogin.postValue(!isLogin.value!!)
    }

    fun getIsLogin(): LiveData<Boolean>? {
        return isLogin
    }
}