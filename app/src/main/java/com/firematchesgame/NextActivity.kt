package com.firematchesgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.model.Singleton

class NextActivity : AppCompatActivity() {

    private val tag = "Next_Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

//        val singleton = Singleton.instance // singleton works
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].rowNo} y is ${singleton.fireMatchesList!![0].colNo}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].rowNo} y is ${singleton.fireMatchesList!![1].colNo}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].rowNo} y is ${singleton.fireMatchesList!![2].colNo}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].rowNo} y is ${singleton.fireMatchesList!![3].colNo}")
    }
}
