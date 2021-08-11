package com.example.tddapptest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tddapptest.model.UserData

class LoginViewModel: ViewModel() {

    private val _userLiveData = MutableLiveData<UserData>()
    val userLiveData: LiveData<UserData> get() = _userLiveData

    private val _loginCheckLiveData = MutableLiveData<Boolean>()
    val loginCheckLiveData: LiveData<Boolean> get() = _loginCheckLiveData

    private val _loginFail = MutableLiveData<Boolean>()
    val loginFail: LiveData<Boolean> get() = _loginFail

    fun loginIdCheck(id: String): Boolean {
        return Regex("^[a-z]+[a-z0-9]{5,19}$").matches(id)
    }

    fun loginPwCheck(pw: String): Boolean {
        return Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$").matches(pw)
    }

    fun login(id: String, pw: String) {
        if(loginIdCheck(id) && loginPwCheck(pw)) {
            if(id == "admin123" && pw == "test1235@")
                _userLiveData.value = UserData("admin12a", "admin")
            else
                _loginFail.value = true
        } else {
            _loginCheckLiveData.value = true
        }
    }
}