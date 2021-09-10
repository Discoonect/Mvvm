package com.kks.mvvm.module

import com.kks.mvvm.main.MainViewModel
import com.kks.mvvm.rep.TestRep
import com.kks.mvvm.rep.TestRepImpl
import org.koin.dsl.module

val testModule = module {
    single<TestRep> { TestRepImpl() }

    factory { MainViewModel(get()) }
}