package com.model

class Singleton private constructor(){
    var fireMatchesList: ArrayList<List<FireMatch>>? = null
    init {
        fireMatchesList = ArrayList()
    }

    companion object {
        val instance: Singleton by lazy { Singleton() }
    }
}