package com.kks.mvvm.rep

interface TestRep {
    fun giveTest() : String
}

class TestRepImpl() : TestRep {
    override fun giveTest() = "테스트 중 입니다 !"
}