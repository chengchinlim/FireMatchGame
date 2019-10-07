package com.firematchesgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.model.FireMatch
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

        // testing
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![2][1])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![0][0])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![4][0])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![8][3])
//        for (neighbor in horizontalNeighbors) {
//            Log.d(tag, "x is ${neighbor.xCoord} y is ${neighbor.yCoord}")
//        }
    }

    fun m80Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![8][0])
    }

    fun m81Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![8][1])
    }

    fun m82Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![8][2])
    }

    fun m83Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![8][3])
    }

    fun m00Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![0][0])
    }

    fun m01Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![0][1])
    }

    fun m02Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![0][2])
    }

    fun m03Clicked(view: View) {
        showCoordinates(singleton.fireMatchesList!![0][3])
    }

    private fun showCoordinates(fireMatch: FireMatch) { // testing
        Toast.makeText(this, "x is ${fireMatch.xCoord} y is ${fireMatch.yCoord}", Toast.LENGTH_SHORT).show()
    }

    private fun setXY()  {
        var list = ArrayList<FireMatch>()
        list.add(FireMatch(m00))
        list.add(FireMatch(m01))
        list.add(FireMatch(m02))
        list.add(FireMatch(m03))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m10))
        list.add(FireMatch(m11))
        list.add(FireMatch(m12))
        list.add(FireMatch(m13))
        list.add(FireMatch(m14))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m20))
        list.add(FireMatch(m21))
        list.add(FireMatch(m22))
        list.add(FireMatch(m23))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m30))
        list.add(FireMatch(m31))
        list.add(FireMatch(m32))
        list.add(FireMatch(m33))
        list.add(FireMatch(m34))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m40))
        list.add(FireMatch(m41))
        list.add(FireMatch(m42))
        list.add(FireMatch(m43))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m50))
        list.add(FireMatch(m51))
        list.add(FireMatch(m52))
        list.add(FireMatch(m53))
        list.add(FireMatch(m54))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m60))
        list.add(FireMatch(m61))
        list.add(FireMatch(m62))
        list.add(FireMatch(m63))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m70))
        list.add(FireMatch(m71))
        list.add(FireMatch(m72))
        list.add(FireMatch(m73))
        list.add(FireMatch(m74))
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch(m80))
        list.add(FireMatch(m81))
        list.add(FireMatch(m82))
        list.add(FireMatch(m83))
        singleton.fireMatchesList!!.add(list)


        for ((x, fireMatchesList) in singleton.fireMatchesList!!.withIndex()) {
            for ((y, fireMatch) in fireMatchesList.withIndex()) {
                fireMatch.xCoord = x
                fireMatch.yCoord = y
            }
        }

//        for (fireMatchList in singleton.fireMatchesList!!) { // testing
//            for (fireMatch in fireMatchList) {
//                Log.d(tag, "x is ${fireMatch.xCoord} y is ${fireMatch.yCoord}")
//            }
//        }
//
//        val intent = Intent(this, NextActivity::class.java)
//        startActivity(intent)
    }

    private fun getHorizontalNeighbors(fireMatch: FireMatch): List<FireMatch> {
        val x = fireMatch.xCoord
        val y = fireMatch.yCoord
        val horizontalNeighbors = ArrayList<FireMatch>()

        if (y - 1 >= 0) {
            horizontalNeighbors.add(singleton.fireMatchesList!![x][y - 1]) // left
        }
        if (x + 1 <= 8) {
            horizontalNeighbors.add(singleton.fireMatchesList!![x + 1][y]) // top left
            horizontalNeighbors.add(singleton.fireMatchesList!![x + 1][y + 1]) // top right
        }
        if (x - 1 >= 0) {
            horizontalNeighbors.add(singleton.fireMatchesList!![x - 1][y]) // bottom left
            horizontalNeighbors.add(singleton.fireMatchesList!![x - 1][y + 1]) // bottom right
        }
        if (y + 1 <= 3) {
            horizontalNeighbors.add(singleton.fireMatchesList!![x][y + 1]) // right
        }
        return horizontalNeighbors
    }

    private fun getVerticalNeighbors(fireMatch: FireMatch) {

    }
}
