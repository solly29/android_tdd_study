package com.example.tddapptest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tddapptest.R
import com.example.tddapptest.databinding.ActivityJoinBinding
import com.example.tddapptest.databinding.ActivityMainBinding

class JoinActivity: AppCompatActivity() {

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
    }
}