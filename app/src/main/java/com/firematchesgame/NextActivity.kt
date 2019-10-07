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
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].xCoord} y is ${singleton.fireMatchesList!![0].yCoord}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].xCoord} y is ${singleton.fireMatchesList!![1].yCoord}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].xCoord} y is ${singleton.fireMatchesList!![2].yCoord}")
//        Log.d(tag, "x is ${singleton.fireMatchesList!![0].xCoord} y is ${singleton.fireMatchesList!![3].yCoord}")
    }
}
