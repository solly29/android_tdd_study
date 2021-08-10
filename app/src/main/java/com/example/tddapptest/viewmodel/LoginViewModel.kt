package com.example.tddapptest.viewmodel

import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    fun loginIdCheck(id: String): Boolean {
        return Regex("^[a-z]+[a-z0-9]{5,19}$").matches(id)
    }

    fun loginPwCheck(pw: String): Boolean {
        return Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$").matches(pw)
    }
}