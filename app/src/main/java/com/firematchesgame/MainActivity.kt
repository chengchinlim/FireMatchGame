package com.firematchesgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.model.Firematch
import com.model.Singleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "Main_Activity"


    private val singleton = Singleton.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setXY()

        val display = resources.displayMetrics
        Log.d(tag, "Width: " +  display.widthPixels) // 1080
        Log.d(tag, "Height: " + display.heightPixels) // 1998
    }

    fun m80Clicked(view: View) {
        showCoordinates(8, 0)
    }

    fun m81Clicked(view: View) {
        showCoordinates(8, 1)
    }

    fun m82Clicked(view: View) {
        showCoordinates(8, 2)
    }

    fun m83Clicked(view: View) {
        showCoordinates(8, 3)
    }

    fun m00Clicked(view: View) {
        showCoordinates(0, 0)
    }

    fun m01Clicked(view: View) {
        showCoordinates(0, 1)
    }

    fun m02Clicked(view: View) {
        showCoordinates(0, 2)
    }

    fun m03Clicked(view: View) {
        showCoordinates(0, 3)
    }

    private fun showCoordinates(x: Int, y: Int) { // for testing
        Toast.makeText(this, "x is $x y is $y", Toast.LENGTH_SHORT).show()
    }

    private fun setXY()  {
        singleton.firematches!!.add(Firematch(m00))
        singleton.firematches!!.add(Firematch(m01))
        singleton.firematches!!.add(Firematch(m02))
        singleton.firematches!!.add(Firematch(m03))

//        singleton.firematches!!.add(Firematch(m10))
//        singleton.firematches!!.add(Firematch(m11))
//        singleton.firematches!!.add(Firematch(m12))
//        singleton.firematches!!.add(Firematch(m13))
//        singleton.firematches!!.add(Firematch(m14))
//
//        singleton.firematches!!.add(Firematch(m20))
//        singleton.firematches!!.add(Firematch(m21))
//        singleton.firematches!!.add(Firematch(m22))
//        singleton.firematches!!.add(Firematch(m23))
//
//        singleton.firematches!!.add(Firematch(m30))
//        singleton.firematches!!.add(Firematch(m31))
//        singleton.firematches!!.add(Firematch(m32))
//        singleton.firematches!!.add(Firematch(m33))
//        singleton.firematches!!.add(Firematch(m34))
//
//        singleton.firematches!!.add(Firematch(m40))
//        singleton.firematches!!.add(Firematch(m41))
//        singleton.firematches!!.add(Firematch(m42))
//        singleton.firematches!!.add(Firematch(m43))
//
//        singleton.firematches!!.add(Firematch(m50))
//        singleton.firematches!!.add(Firematch(m51))
//        singleton.firematches!!.add(Firematch(m52))
//        singleton.firematches!!.add(Firematch(m53))
//        singleton.firematches!!.add(Firematch(m54))
//
//        singleton.firematches!!.add(Firematch(m60))
//        singleton.firematches!!.add(Firematch(m61))
//        singleton.firematches!!.add(Firematch(m62))
//        singleton.firematches!!.add(Firematch(m63))
//
//        singleton.firematches!!.add(Firematch(m70))
//        singleton.firematches!!.add(Firematch(m71))
//        singleton.firematches!!.add(Firematch(m72))
//        singleton.firematches!!.add(Firematch(m73))
//        singleton.firematches!!.add(Firematch(m74))

        singleton.firematches!!.add(Firematch(m80))
        singleton.firematches!!.add(Firematch(m81))
        singleton.firematches!!.add(Firematch(m82))
        singleton.firematches!!.add(Firematch(m83))

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



//        for (firematch in singleton.firematches!!) {
//            Log.d(tag, "x is ${firematch.xCoord} y is ${firematch.yCoord}")
//        }
//
//        val intent = Intent(this, NextActivity::class.java)
//        startActivity(intent)
    }

    private fun getNeighbors() {



    }
}
