package com.example.tddapptest.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tddapptest.R
import com.example.tddapptest.databinding.ActivityLoginBinding
import com.example.tddapptest.viewmodel.LoginViewModel

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        with(binding) {
            buttonLogin.setOnClickListener {
                viewModel.login(editId.text.toString(), editPw.text.toString())
            }

            buttonJoin.setOnClickListener {
                Intent(this@LoginActivity, JoinActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }

        with(viewModel) {
            loginCheckLiveData.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "ID, PW가 유효하지 않습니다.", Toast.LENGTH_SHORT).show()
            })

            loginFail.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "ID, PW가 틀립니다.", Toast.LENGTH_SHORT).show()
            })

            userLiveData.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "${it.name}님이 로그인 하셨습니다.", Toast.LENGTH_SHORT).show()
                Intent(this@LoginActivity, MainActivity::class.java).apply {
                    startActivity(this)
                }
            })
        }
    }
}