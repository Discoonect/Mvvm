package com.kks.mvvm.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kks.mvvm.R
import com.kks.mvvm.base.BaseActivity
import com.kks.mvvm.databinding.ActivityMainBinding
import com.kks.mvvm.rep.TestRep
import org.koin.java.KoinJavaComponent.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: BaseActivity<ActivityMainBinding,MainViewModel>(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel


    }
}