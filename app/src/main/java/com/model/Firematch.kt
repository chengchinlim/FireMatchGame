package com.model

import android.widget.ImageView

class Firematch(i: ImageView, x: Int, y: Int) {
    var clickable = true
    var leftClickable = true
    var rightClickable = true
    var topClickable = true
    var bottomClickable = true

    var imageView = i
    var xCoord = x
    var yCoord = y
}