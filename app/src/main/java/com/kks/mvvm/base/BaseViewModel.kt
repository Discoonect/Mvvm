package com.kks.mvvm.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kks.mvvm.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(){
    protected val compositeDisposable = CompositeDisposable()

    private var _backClick = SingleLiveEvent<Unit>()
    private val _isLoading = MutableLiveData<Boolean>(false)
    private val _isLottieLoading = MutableLiveData<Boolean>(false)
    private var _disableClick = SingleLiveEvent<Unit>()

    val isLoading: LiveData<Boolean> get() = _isLoading
    val backClick: LiveData<Unit> get() = _backClick
    val disableClick: LiveData<Unit> get() = _disableClick
    val isLottieLoading: LiveData<Boolean> get() = _isLottieLoading

    fun showProgress() {
        _isLoading.value = true
    }

    fun hideProgress() {
        _isLoading.value = false
    }

    fun showLottieProgress() {
        _isLottieLoading.value = true
    }

    fun hideLottieProgress() {
        _isLottieLoading.value = false
    }

    fun onBackClick() {
        _backClick.call()
    }

    fun disableClick(){
        _disableClick.call()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
