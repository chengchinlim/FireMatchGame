package com.model

class Singleton private constructor(){
    var firematches: ArrayList<Firematch>? = null
    init {
        firematches = ArrayList()
    }

    companion object {
        val instance: Singleton by lazy { Singleton() }
    }
}