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
        showCoordinates(singleton.firematches!![8][0])
    }

    fun m81Clicked(view: View) {
        showCoordinates(singleton.firematches!![8][1])
    }

    fun m82Clicked(view: View) {
        showCoordinates(singleton.firematches!![8][2])
    }

    fun m83Clicked(view: View) {
        showCoordinates(singleton.firematches!![8][3])
    }

    fun m00Clicked(view: View) {
        showCoordinates(singleton.firematches!![0][0])
    }

    fun m01Clicked(view: View) {
        showCoordinates(singleton.firematches!![0][1])
    }

    fun m02Clicked(view: View) {
        showCoordinates(singleton.firematches!![0][2])
    }

    fun m03Clicked(view: View) {
        showCoordinates(singleton.firematches!![0][3])
    }

    private fun showCoordinates(fireMatch: Firematch) { // testing
        Toast.makeText(this, "x is ${fireMatch.xCoord} y is ${fireMatch.yCoord}", Toast.LENGTH_SHORT).show()
    }

    private fun setXY()  {
        var list = ArrayList<Firematch>()
        list.add(Firematch(m00))
        list.add(Firematch(m01))
        list.add(Firematch(m02))
        list.add(Firematch(m03))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m10))
        list.add(Firematch(m11))
        list.add(Firematch(m12))
        list.add(Firematch(m13))
        list.add(Firematch(m14))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m20))
        list.add(Firematch(m21))
        list.add(Firematch(m22))
        list.add(Firematch(m23))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m30))
        list.add(Firematch(m31))
        list.add(Firematch(m32))
        list.add(Firematch(m33))
        list.add(Firematch(m34))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m40))
        list.add(Firematch(m41))
        list.add(Firematch(m42))
        list.add(Firematch(m43))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m50))
        list.add(Firematch(m51))
        list.add(Firematch(m52))
        list.add(Firematch(m53))
        list.add(Firematch(m54))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m60))
        list.add(Firematch(m61))
        list.add(Firematch(m62))
        list.add(Firematch(m63))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m70))
        list.add(Firematch(m71))
        list.add(Firematch(m72))
        list.add(Firematch(m73))
        list.add(Firematch(m74))
        singleton.firematches!!.add(list)

        list = ArrayList()
        list.add(Firematch(m80))
        list.add(Firematch(m81))
        list.add(Firematch(m82))
        list.add(Firematch(m83))
        singleton.firematches!!.add(list)


        for ((x, fireMatchesList) in singleton.firematches!!.withIndex()) {
            for ((y, fireMatch) in fireMatchesList.withIndex()) {
                fireMatch.xCoord = x
                fireMatch.yCoord = y
            }
        }

        for (fireMatchList in singleton.firematches!!) { // testing
            for (fireMatch in fireMatchList) {
                Log.d(tag, "x is ${fireMatch.xCoord} y is ${fireMatch.yCoord}")
            }
        }
//
//        val intent = Intent(this, NextActivity::class.java)
//        startActivity(intent)
    }

    private fun getNeighbors() {



    }
}
