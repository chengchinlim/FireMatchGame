package com.firematchesgame

import com.model.Firematch
import com.model.Singleton
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {

    private val singleton = Singleton.instance

    @Test
    fun main() {
//        MainActivity().setup()

        assertEquals(singleton.firematches!![0].xCoord, 0)
        assertEquals(singleton.firematches!![0].yCoord, 0)
        assertEquals(singleton.firematches!![1].xCoord, 0)
        assertEquals(singleton.firematches!![1].yCoord, 1)
        assertEquals(singleton.firematches!![2].xCoord, 0)
        assertEquals(singleton.firematches!![2].yCoord, 2)
        assertEquals(singleton.firematches!![3].xCoord, 0)
        assertEquals(singleton.firematches!![3].yCoord, 3)
    }
}
