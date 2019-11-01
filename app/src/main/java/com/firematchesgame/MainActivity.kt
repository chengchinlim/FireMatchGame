package com.firematchesgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.model.FireMatch
import com.model.Singleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "Main_Activity"

    private val singleton = Singleton.instance
    private var screenHeightPixels = 0
    private var screenWidthPixels = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setXY()

        val display = resources.displayMetrics
        Log.d(tag, "Width: " +  display.widthPixels) // 1080 = 320dp
        Log.d(tag, "Height: " + display.heightPixels) // 1998 = 592dp
        screenWidthPixels = display.widthPixels
        screenHeightPixels = display.heightPixels



        // testing
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![2][1])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![0][0])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![4][0])
//        val horizontalNeighbors = getHorizontalNeighbors(singleton.fireMatchesList!![8][3])
//        for (neighbor in horizontalNeighbors) {
//            Log.d(tag, "x is ${neighbor.xCoord} y is ${neighbor.yCoord}")
//        }
    }

    override fun onStart() {
        super.onStart()
        setImageViewSize(m80, 18.75f, 0.84f)
        setImageViewMargin(m80, 9.38f, 8.45f)
        setImageViewSize(m81, 18.75f, 0.84f)
        setImageViewMargin(m81, 0f, 8.45f)
        setImageViewSize(m82, 18.75f, 0.84f)
        setImageViewMargin(m82, 0f, 8.45f)
        setImageViewSize(m83, 18.75f, 0.84f)
        setImageViewMargin(m83, 0f, 8.45f)

        setImageViewSize(m70, 1.28f, 10.14f)
        setImageViewMargin(m70, 9.38f, 0f)
        setImageViewSize(m71, 1.28f, 10.14f)
        setImageViewMargin(m71, 17.19f, 0f)
        setImageViewSize(m72, 1.28f, 10.14f)
        setImageViewMargin(m72, 17.19f, 0f)
        setImageViewSize(m73, 1.28f, 10.14f)
        setImageViewMargin(m73, 17.19f, 0f)
        setImageViewSize(m74, 1.28f, 10.14f)
        setImageViewMargin(m74, 17.19f, 0f)

        setImageViewSize(m60, 18.75f, 0.84f)
        setImageViewMargin(m60, 9.38f, 0f)
        setImageViewSize(m61, 18.75f, 0.84f)
        setImageViewSize(m62, 18.75f, 0.84f)
        setImageViewSize(m63, 18.75f, 0.84f)

        setImageViewSize(m50, 1.28f, 10.14f)
        setImageViewMargin(m50, 9.38f, 0f)
        setImageViewSize(m51, 1.28f, 10.14f)
        setImageViewMargin(m51, 17.19f, 0f)
        setImageViewSize(m52, 1.28f, 10.14f)
        setImageViewMargin(m52, 17.19f, 0f)
        setImageViewSize(m53, 1.28f, 10.14f)
        setImageViewMargin(m53, 17.19f, 0f)
        setImageViewSize(m54, 1.28f, 10.14f)
        setImageViewMargin(m54, 17.19f, 0f)

        setImageViewSize(m40, 18.75f, 0.84f)
        setImageViewMargin(m40, 9.38f, 0f)
        setImageViewSize(m41, 18.75f, 0.84f)
        setImageViewSize(m42, 18.75f, 0.84f)
        setImageViewSize(m43, 18.75f, 0.84f)

        setImageViewSize(m30, 1.28f, 10.14f)
        setImageViewMargin(m30, 9.38f, 0f)
        setImageViewSize(m31, 1.28f, 10.14f)
        setImageViewMargin(m31, 17.19f, 0f)
        setImageViewSize(m32, 1.28f, 10.14f)
        setImageViewMargin(m32, 17.19f, 0f)
        setImageViewSize(m33, 1.28f, 10.14f)
        setImageViewMargin(m33, 17.19f, 0f)
        setImageViewSize(m34, 1.28f, 10.14f)
        setImageViewMargin(m34, 17.19f, 0f)

        setImageViewSize(m20, 18.75f, 0.84f)
        setImageViewMargin(m20, 9.38f, 0f)
        setImageViewSize(m21, 18.75f, 0.84f)
        setImageViewSize(m22, 18.75f, 0.84f)
        setImageViewSize(m23, 18.75f, 0.84f)

        setImageViewSize(m10, 1.28f, 10.14f)
        setImageViewMargin(m10, 9.38f, 0f)
        setImageViewSize(m11, 1.28f, 10.14f)
        setImageViewMargin(m11, 17.19f, 0f)
        setImageViewSize(m12, 1.28f, 10.14f)
        setImageViewMargin(m12, 17.19f, 0f)
        setImageViewSize(m13, 1.28f, 10.14f)
        setImageViewMargin(m13, 17.19f, 0f)
        setImageViewSize(m14, 1.28f, 10.14f)
        setImageViewMargin(m14, 17.19f, 0f)

        setImageViewSize(m00, 18.75f, 0.84f)
        setImageViewMargin(m00, 9.38f, 0f)
        setImageViewSize(m01, 18.75f, 0.84f)
        setImageViewSize(m02, 18.75f, 0.84f)
        setImageViewSize(m03, 18.75f, 0.84f)

    }

    private fun setImageViewSize(iv: ImageView, widthPercent: Float, heightPercent: Float) {
        if (widthPercent != -1f) {
            iv.layoutParams.width = percentToPixels(screenWidthPixels, widthPercent)
        }
        if (heightPercent != -1f) {
            iv.layoutParams.height = percentToPixels(screenHeightPixels, heightPercent)
        }
    }

    private fun setImageViewMargin(iv: ImageView, leftMarginPercent: Float, topMarginPercent: Float) {
        val leftMargin = percentToPixels(screenWidthPixels, leftMarginPercent)
        val topMargin = percentToPixels(screenHeightPixels, topMarginPercent)
        val param = iv.layoutParams as ConstraintLayout.LayoutParams
        param.leftMargin = leftMargin
        param.topMargin = topMargin
        iv.layoutParams = param
    }

    private fun percentToPixels(screenPixels: Int, percent: Float): Int {
        return (screenPixels * percent / 100).toInt()
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
