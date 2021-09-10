package com.kks.mvvm.main

import com.github.appintro.AppIntro
import com.kks.mvvm.base.BaseViewModel
import com.kks.mvvm.rep.TestRep
import kotlin.reflect.KProperty

class MainViewModel(private val rep : TestRep) : BaseViewModel() {

    fun test() = "${rep.giveTest()} from $this"
}