package com.firematchesgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.model.FireMatch
import com.model.Singleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "Main_Activity"

    private val singleton = Singleton.instance
    private var screenHeightPixels = 0
    private var screenWidthPixels = 0
    private var turn = 1
    private var blueChoices = ArrayList<FireMatch>()
    private val restartFragment = RestartFragment()
    private val helpFragment = HelpFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRowCol()
        addImageViewIntoFireMatch()

        val display = resources.displayMetrics
        Log.d(tag, "Width: " +  display.widthPixels) // 1080 = 320dp
        Log.d(tag, "Height: " + display.heightPixels) // 1998 = 592dp
        screenWidthPixels = display.widthPixels
        screenHeightPixels = display.heightPixels


//        val verticalNeighbors = getVerticalNeighbors(singleton.fireMatchesList!![5][1])
        val verticalNeighbors = getVerticalNeighbors(singleton.fireMatchesList!![1][1])
        for (neighbor in verticalNeighbors) {
            Log.d(tag, "row is ${neighbor.rowNo} col is ${neighbor.colNo}")
        }
    }

    override fun onStart() {
        super.onStart()
        setBoardLayout()
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

    private fun makeAllNotClickable() {
        for ((row, fireMatchesList) in singleton.fireMatchesList!!.withIndex()) {
            for ((col, fireMatch) in fireMatchesList.withIndex()) {
                fireMatch.imageView!!.isClickable = false
            }
        }
    }

    private fun makeAllBlueUnClickBlack(fireMatches: List<FireMatch>, currRowNo: Int, currColNo: Int) {
        for (fm in fireMatches) {
            if (currRowNo == fm.rowNo && currColNo == fm.colNo) {
                continue
            }
            if (fm.rowNo % 2 == 0) {
                fm.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horizontal_dotted))
            } else {
                fm.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vertical_dotted))
            }
        }
    }

    private fun clickFunction(rowNo: Int, colNo: Int, isHorizontal: Boolean) {
//        showCoordinates(singleton.fireMatchesList!![rowNo][colNo]) // testing
        makeAllNotClickable()
        makeAllBlueUnClickBlack(blueChoices, rowNo, colNo)
        blueChoices = ArrayList()
        if (isHorizontal) {
            singleton.fireMatchesList!![rowNo][colNo].imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horizontal_red))
        } else {
            singleton.fireMatchesList!![rowNo][colNo].imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vertical_red))
        }
        val filteredNeighbors = getFilteredNeighbors(singleton.fireMatchesList!![rowNo][colNo])
        if (filteredNeighbors.isEmpty()) {
            Toast.makeText(this, "If now is your turn, YOU LOST!!!", Toast.LENGTH_LONG).show()
        }
        for (fm in filteredNeighbors) {
            fm.imageView!!.isClickable = true
            blueChoices.add(fm)
            if (fm.rowNo % 2 == 0) {
                fm.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horizontal_dotted_blue))
            } else {
                fm.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vertical_dotted_blue))
            }
        }
        singleton.fireMatchesList!![rowNo][colNo].alreadyClicked = true
        turn++
    }

    fun onHelpClicked(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, helpFragment).commit()
        fragmentContainer.visibility = View.VISIBLE
    }

    fun onOkClicked(view: View) {
        helpFragment.dismiss()
    }

    fun onRestartClicked(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, restartFragment).commit()
        fragmentContainer.visibility = View.VISIBLE
    }

    fun onYesClicked(view: View) {
//        Toast.makeText(this, "Yes is clicked", Toast.LENGTH_SHORT).show() // testing
        resetBoard()
        restartFragment.dismiss()
    }

    fun onNoClicked(view: View) {
//        Toast.makeText(this, "No is clicked", Toast.LENGTH_SHORT).show() // testing
        restartFragment.dismiss()
    }

    private fun resetBoard() {
        for ((row, fireMatchesList) in singleton.fireMatchesList!!.withIndex()) {
            for ((col, fireMatch) in fireMatchesList.withIndex()) {
                fireMatch.alreadyClicked = false
                fireMatch.imageView!!.isClickable = true
                if (fireMatch.rowNo % 2 == 0) {
                    fireMatch.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horizontal_dotted))
                } else {
                    fireMatch.imageView!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vertical_dotted))
                }
            }
        }
    }

    fun m80Clicked(view: View) {
        clickFunction(8, 0, true)
    }

    fun m81Clicked(view: View) {
        clickFunction(8, 1, true)
    }

    fun m82Clicked(view: View) {
        clickFunction(8, 2, true)
    }

    fun m83Clicked(view: View) {
        clickFunction(8, 3, true)
    }

    fun m70Clicked(view: View) {
        clickFunction(7,0, false)
    }

    fun m71Clicked(view: View) {
        clickFunction(7,1, false)
    }

    fun m72Clicked(view: View) {
        clickFunction(7,2, false)
    }

    fun m73Clicked(view: View) {
        clickFunction(7,3, false)
    }

    fun m74Clicked(view: View) {
        clickFunction(7,4, false)
    }

    fun m60Clicked(view: View) {
        clickFunction(6,0, true)
    }

    fun m61Clicked(view: View) {
        clickFunction(6,1, true)
    }

    fun m62Clicked(view: View) {
        clickFunction(6,2, true)
    }

    fun m63Clicked(view: View) {
        clickFunction(6,3, true)
    }

    fun m50Clicked(view: View) {
        clickFunction(5,0, false)
    }

    fun m51Clicked(view: View) {
        clickFunction(5,1, false)
    }

    fun m52Clicked(view: View) {
        clickFunction(5,2, false)
    }

    fun m53Clicked(view: View) {
        clickFunction(5,3, false)
    }

    fun m54Clicked(view: View) {
        clickFunction(5,4, false)
    }

    fun m40Clicked(view: View) {
        clickFunction(4,0, true)
    }

    fun m41Clicked(view: View) {
        clickFunction(4,1, true)
    }

    fun m42Clicked(view: View) {
        clickFunction(4,2, true)
    }

    fun m43Clicked(view: View) {
        clickFunction(4,3, true)
    }

    fun m30Clicked(view: View) {
        clickFunction(3,0, false)
    }

    fun m31Clicked(view: View) {
        clickFunction(3,1, false)
    }

    fun m32Clicked(view: View) {
        clickFunction(3,2, false)
    }

    fun m33Clicked(view: View) {
        clickFunction(3,3, false)
    }

    fun m34Clicked(view: View) {
        clickFunction(3,4, false)
    }

    fun m20Clicked(view: View) {
        clickFunction(2,0, true)
    }

    fun m21Clicked(view: View) {
        clickFunction(2,1, true)
    }

    fun m22Clicked(view: View) {
        clickFunction(2,2, true)
    }

    fun m23Clicked(view: View) {
        clickFunction(2,3, true)
    }

    fun m10Clicked(view: View) {
        clickFunction(1,0, false)
    }

    fun m11Clicked(view: View) {
        clickFunction(1,1, false)
    }

    fun m12Clicked(view: View) {
        clickFunction(1,2, false)
    }

    fun m13Clicked(view: View) {
        clickFunction(1,3, false)
    }

    fun m14Clicked(view: View) {
        clickFunction(1,4, false)
    }

    fun m00Clicked(view: View) {
        clickFunction(0,0, true)
    }

    fun m01Clicked(view: View) {
        clickFunction(0,1, true)
    }

    fun m02Clicked(view: View) {
        clickFunction(0,2, true)
    }

    fun m03Clicked(view: View) {
        clickFunction(0,3, true)
    }

    private fun showCoordinates(fireMatch: FireMatch) { // testing
        Toast.makeText(this, "row is ${fireMatch.rowNo} col is ${fireMatch.colNo}", Toast.LENGTH_SHORT).show()
    }

    fun getFilteredNeighbors(fireMatch: FireMatch): List<FireMatch> { // should include in unit testing
        val neighbors = if (fireMatch.rowNo % 2 == 0) {
            getHorizontalNeighbors(fireMatch)
        } else {
            getVerticalNeighbors(fireMatch)
        }
        val filteredNeighbors = ArrayList<FireMatch>()
        for (fm in neighbors) {
            if (isValid(fm, fireMatch)) {
                filteredNeighbors.add(fm)
            }
        }
        return filteredNeighbors
    }

    fun isValid(fireMatch: FireMatch, parentMatch: FireMatch): Boolean { // should include in unit testing
        if (fireMatch.alreadyClicked) {
            return false
        }
        val neighbors = if (fireMatch.rowNo % 2 == 0) {
            getHorizontalNeighbors(fireMatch)
        } else {
            getVerticalNeighbors(fireMatch)
        }
        for (fm in neighbors) {
            if (fm.rowNo == parentMatch.rowNo && fm.colNo == parentMatch.colNo) {
                continue
            }
            if (fm.alreadyClicked) {
                return false
            }
        }
        return true
    }

    fun getHorizontalNeighbors(fireMatch: FireMatch): List<FireMatch> { // should include in unit test
        val row = fireMatch.rowNo
        val col = fireMatch.colNo
        val horizontalNeighbors = ArrayList<FireMatch>()
        if (row % 2 != 0) {
            return horizontalNeighbors // zero elements
        }

        if (col - 1 >= 0) {
            horizontalNeighbors.add(singleton.fireMatchesList!![row][col - 1]) // left (horizontal line)
        }
        if (row + 1 <= 8) {
            horizontalNeighbors.add(singleton.fireMatchesList!![row + 1][col]) // top left (vertical line)
            if (col + 1 <= 4) {
                horizontalNeighbors.add(singleton.fireMatchesList!![row + 1][col + 1]) // top right (vertical line)
            }
        }
        if (row - 1 >= 0) {
            horizontalNeighbors.add(singleton.fireMatchesList!![row - 1][col]) // bottom left (vertical line)
            if (col + 1 <= 4) {
                horizontalNeighbors.add(singleton.fireMatchesList!![row - 1][col + 1]) // bottom right (vertical line)
            }
        }
        if (col + 1 <= 3) {
            horizontalNeighbors.add(singleton.fireMatchesList!![row][col + 1]) // right (horizontal line)
        }
        return horizontalNeighbors
    }

    fun getVerticalNeighbors(fireMatch: FireMatch): List<FireMatch> { // should include in unit test
        val row = fireMatch.rowNo
        val col = fireMatch.colNo
        val verticalNeighbors = ArrayList<FireMatch>()
        if (row % 2 == 0) {
            return verticalNeighbors // zero elements
        }

        if (row + 2 <= 8) { // top (vertical line)
            verticalNeighbors.add(singleton.fireMatchesList!![row + 2][col])
        }
        if (row + 1 <= 8) {
            if (col < 4) {
                verticalNeighbors.add(singleton.fireMatchesList!![row + 1][col]) // top right (horizontal line)
            }
            if (col - 1 >= 0) {
                verticalNeighbors.add(singleton.fireMatchesList!![row + 1][col - 1]) // top left (horizontal line)
            }
        }
        if (row - 1 >= 0) {
            if (col < 4) {
                verticalNeighbors.add(singleton.fireMatchesList!![row - 1][col]) // bottom right (horizontal line)
            }
            if (col - 1 >= 0) {
                verticalNeighbors.add(singleton.fireMatchesList!![row - 1][col - 1]) // bottom left (horizontal line)
            }
        }
        if (row - 2 >= 0) { // bottom (vertical line)
            verticalNeighbors.add(singleton.fireMatchesList!![row - 2][col])
        }
        return verticalNeighbors
    }

    private fun setBoardLayout() {
        setImageViewSize(m80, 18.75f, 2.52f)
        setImageViewMargin(m80, 9.38f, 8.45f)
        setImageViewSize(m81, 18.75f, 2.52f)
        setImageViewMargin(m81, 0f, 8.45f)
        setImageViewSize(m82, 18.75f, 2.52f)
        setImageViewMargin(m82, 0f, 8.45f)
        setImageViewSize(m83, 18.75f, 2.52f)
        setImageViewMargin(m83, 0f, 8.45f)

        setImageViewSize(m70, 3.84f, 10.14f)
        setImageViewMargin(m70, 9.38f, 0f)
        setImageViewSize(m71, 3.84f, 10.14f)
        setImageViewMargin(m71, 14.06f, 0f)
        setImageViewSize(m72, 3.84f, 10.14f)
        setImageViewMargin(m72, 14.06f, 0f)
        setImageViewSize(m73, 3.84f, 10.14f)
        setImageViewMargin(m73, 14.06f, 0f)
        setImageViewSize(m74, 3.84f, 10.14f)
        setImageViewMargin(m74, 14.06f, 0f)

        setImageViewSize(m60, 18.75f, 2.52f)
        setImageViewMargin(m60, 9.38f, 0f)
        setImageViewSize(m61, 18.75f, 2.52f)
        setImageViewSize(m62, 18.75f, 2.52f)
        setImageViewSize(m63, 18.75f, 2.52f)

        setImageViewSize(m50, 3.84f, 10.14f)
        setImageViewMargin(m50, 9.38f, 0f)
        setImageViewSize(m51, 3.84f, 10.14f)
        setImageViewMargin(m51, 14.06f, 0f)
        setImageViewSize(m52, 3.84f, 10.14f)
        setImageViewMargin(m52, 14.06f, 0f)
        setImageViewSize(m53, 3.84f, 10.14f)
        setImageViewMargin(m53, 14.06f, 0f)
        setImageViewSize(m54, 3.84f, 10.14f)
        setImageViewMargin(m54, 14.06f, 0f)

        setImageViewSize(m40, 18.75f, 2.52f)
        setImageViewMargin(m40, 9.38f, 0f)
        setImageViewSize(m41, 18.75f, 2.52f)
        setImageViewSize(m42, 18.75f, 2.52f)
        setImageViewSize(m43, 18.75f, 2.52f)

        setImageViewSize(m30, 3.84f, 10.14f)
        setImageViewMargin(m30, 9.38f, 0f)
        setImageViewSize(m31, 3.84f, 10.14f)
        setImageViewMargin(m31, 14.06f, 0f)
        setImageViewSize(m32, 3.84f, 10.14f)
        setImageViewMargin(m32, 14.06f, 0f)
        setImageViewSize(m33, 3.84f, 10.14f)
        setImageViewMargin(m33, 14.06f, 0f)
        setImageViewSize(m34, 3.84f, 10.14f)
        setImageViewMargin(m34, 14.06f, 0f)

        setImageViewSize(m20, 18.75f, 2.52f)
        setImageViewMargin(m20, 9.38f, 0f)
        setImageViewSize(m21, 18.75f, 2.52f)
        setImageViewSize(m22, 18.75f, 2.52f)
        setImageViewSize(m23, 18.75f, 2.52f)

        setImageViewSize(m10, 3.84f, 10.14f)
        setImageViewMargin(m10, 9.38f, 0f)
        setImageViewSize(m11, 3.84f, 10.14f)
        setImageViewMargin(m11, 14.06f, 0f)
        setImageViewSize(m12, 3.84f, 10.14f)
        setImageViewMargin(m12, 14.06f, 0f)
        setImageViewSize(m13, 3.84f, 10.14f)
        setImageViewMargin(m13, 14.06f, 0f)
        setImageViewSize(m14, 3.84f, 10.14f)
        setImageViewMargin(m14, 14.06f, 0f)

        setImageViewSize(m00, 18.75f, 2.52f)
        setImageViewMargin(m00, 9.38f, 0f)
        setImageViewSize(m01, 18.75f, 2.52f)
        setImageViewSize(m02, 18.75f, 2.52f)
        setImageViewSize(m03, 18.75f, 2.52f)
    }

    fun setRowCol(): List<List<FireMatch>>  { // should include in unit test
        var list = ArrayList<FireMatch>()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)

        list = ArrayList()
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        list.add(FireMatch())
        singleton.fireMatchesList!!.add(list)


        for ((row, fireMatchesList) in singleton.fireMatchesList!!.withIndex()) {
            for ((col, fireMatch) in fireMatchesList.withIndex()) {
                fireMatch.rowNo = row
                fireMatch.colNo = col
            }
        }

        return singleton.fireMatchesList!!
    }

    private fun addImageViewIntoFireMatch()  {
        singleton.fireMatchesList!![0][0].imageView = m00
        singleton.fireMatchesList!![0][1].imageView = m01
        singleton.fireMatchesList!![0][2].imageView = m02
        singleton.fireMatchesList!![0][3].imageView = m03

        singleton.fireMatchesList!![1][0].imageView = m10
        singleton.fireMatchesList!![1][1].imageView = m11
        singleton.fireMatchesList!![1][2].imageView = m12
        singleton.fireMatchesList!![1][3].imageView = m13
        singleton.fireMatchesList!![1][4].imageView = m14

        singleton.fireMatchesList!![2][0].imageView = m20
        singleton.fireMatchesList!![2][1].imageView = m21
        singleton.fireMatchesList!![2][2].imageView = m22
        singleton.fireMatchesList!![2][3].imageView = m23

        singleton.fireMatchesList!![3][0].imageView = m30
        singleton.fireMatchesList!![3][1].imageView = m31
        singleton.fireMatchesList!![3][2].imageView = m32
        singleton.fireMatchesList!![3][3].imageView = m33
        singleton.fireMatchesList!![3][4].imageView = m34

        singleton.fireMatchesList!![4][0].imageView = m40
        singleton.fireMatchesList!![4][1].imageView = m41
        singleton.fireMatchesList!![4][2].imageView = m42
        singleton.fireMatchesList!![4][3].imageView = m43

        singleton.fireMatchesList!![5][0].imageView = m50
        singleton.fireMatchesList!![5][1].imageView = m51
        singleton.fireMatchesList!![5][2].imageView = m52
        singleton.fireMatchesList!![5][3].imageView = m53
        singleton.fireMatchesList!![5][4].imageView = m54

        singleton.fireMatchesList!![6][0].imageView = m60
        singleton.fireMatchesList!![6][1].imageView = m61
        singleton.fireMatchesList!![6][2].imageView = m62
        singleton.fireMatchesList!![6][3].imageView = m63

        singleton.fireMatchesList!![7][0].imageView = m70
        singleton.fireMatchesList!![7][1].imageView = m71
        singleton.fireMatchesList!![7][2].imageView = m72
        singleton.fireMatchesList!![7][3].imageView = m73
        singleton.fireMatchesList!![7][4].imageView = m74

        singleton.fireMatchesList!![8][0].imageView = m80
        singleton.fireMatchesList!![8][1].imageView = m81
        singleton.fireMatchesList!![8][2].imageView = m82
        singleton.fireMatchesList!![8][3].imageView = m83
    }
}
