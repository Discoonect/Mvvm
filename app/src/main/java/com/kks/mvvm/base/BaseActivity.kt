package com.kks.mvvm.base

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.kks.mvvm.dialog.LottieDialogFragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<B : ViewDataBinding,V: ViewModel>(@LayoutRes val layoutId:Int) : AppCompatActivity() {
    lateinit var binding : B
    lateinit var lottieDialog: LottieDialogFragment
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

    }

    protected fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun showProgressDialog() {
        lottieDialog.show(
            this.supportFragmentManager,
            lottieDialog.tag
        )
    }

    fun hideProgressDialog() {
        if (lottieDialog.isAdded) {
            lottieDialog.dismissAllowingStateLoss()
        }
    }




}