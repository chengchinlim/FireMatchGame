package com.model

import android.widget.ImageView

class FireMatch() {
    var rowNo = 0
    var colNo = 0
    var clickable = true
    var alreadyClicked = false
    var imageView: ImageView? = null

    constructor(i: ImageView): this() {
        imageView = i
    }
}