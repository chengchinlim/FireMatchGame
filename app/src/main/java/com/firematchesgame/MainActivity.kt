package com.firematchesgame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.model.Firematch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tag = "Main_Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val display = resources.displayMetrics
        Log.d(tag, "Width: " +  display.widthPixels) // 1080
        Log.d(tag, "Height: " + display.heightPixels) // 1998

        val firematch = Firematch(h00, 0, 0)
        firematch.imageView.setImageResource(R.drawable.horizontal_dotted_red)
    }

    fun h1Clicked(view: View) {
        Toast.makeText(this, "h1 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun h2Clicked(view: View) {
        Toast.makeText(this, "h2 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun h3Clicked(view: View) {
        Toast.makeText(this, "h3 is clicked", Toast.LENGTH_SHORT).show()
    }

    fun h4Clicked(view: View) {
        Toast.makeText(this, "h4 is clicked", Toast.LENGTH_SHORT).show()
    }
}
