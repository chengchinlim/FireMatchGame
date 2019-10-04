package com.firematchesgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.model.Firematch
import com.model.Singleton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    private val tag = "Main_Activity"


    private val singleton = Singleton.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

        val display = resources.displayMetrics
        Log.d(tag, "Width: " +  display.widthPixels) // 1080
        Log.d(tag, "Height: " + display.heightPixels) // 1998
    }

    fun m80Clicked(view: View) {
        Toast.makeText(this, "h1 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun m81Clicked(view: View) {
        Toast.makeText(this, "h2 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun m82Clicked(view: View) {
        Toast.makeText(this, "h3 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun m83Clicked(view: View) {
        Toast.makeText(this, "h4 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun setup()  {
        singleton.firematches!!.add(Firematch(m00))
        singleton.firematches!!.add(Firematch(m01))
        singleton.firematches!!.add(Firematch(m02))
        singleton.firematches!!.add(Firematch(m03))

//        firematches.add(Firematch(m10))
//        firematches.add(Firematch(m11))
//        firematches.add(Firematch(m12))
//        firematches.add(Firematch(m13))
//        firematches.add(Firematch(m14))
//
//        firematches.add(Firematch(m20))
//        firematches.add(Firematch(m21))
//        firematches.add(Firematch(m22))
//        firematches.add(Firematch(m23))
//
//        firematches.add(Firematch(m30))
//        firematches.add(Firematch(m31))
//        firematches.add(Firematch(m32))
//        firematches.add(Firematch(m33))
//        firematches.add(Firematch(m34))
//
//        firematches.add(Firematch(m40))
//        firematches.add(Firematch(m41))
//        firematches.add(Firematch(m42))
//        firematches.add(Firematch(m43))
//
//        firematches.add(Firematch(m50))
//        firematches.add(Firematch(m51))
//        firematches.add(Firematch(m52))
//        firematches.add(Firematch(m53))
//        firematches.add(Firematch(m54))
//
//        firematches.add(Firematch(m60))
//        firematches.add(Firematch(m61))
//        firematches.add(Firematch(m62))
//        firematches.add(Firematch(m63))
//
//        firematches.add(Firematch(m70))
//        firematches.add(Firematch(m71))
//        firematches.add(Firematch(m72))
//        firematches.add(Firematch(m73))
//        firematches.add(Firematch(m74))
//
//        firematches.add(Firematch(m80))
//        firematches.add(Firematch(m81))
//        firematches.add(Firematch(m82))
//        firematches.add(Firematch(m83))

        var count = 0
        for (x in 0 until 1) {
            if (x % 2 == 0) {
                for (y in 0 until 4) {
                    singleton.firematches!![count].xCoord = x
                    singleton.firematches!![count].yCoord = y
                    count++
                }
            } else {
                for (y in 0 until 5) {
                    singleton.firematches!![count].xCoord = x
                    singleton.firematches!![count].yCoord = y
                    count++
                }
            }
        }



        for (firematch in singleton.firematches!!) {
            Log.d(tag, "x is ${firematch.xCoord} y is ${firematch.yCoord}")
        }

        val intent = Intent(this, NextActivity::class.java)
        startActivity(intent)
    }

    private fun getNeighbors() {



    }
}
