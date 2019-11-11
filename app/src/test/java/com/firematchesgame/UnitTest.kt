package com.firematchesgame

import com.model.Singleton
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {

    private val singleton = Singleton.instance
    private val mainActivity = MainActivity()

    @Test
    fun testMain() {
        mainActivity.setRowCol()
//        testSetRowCol()
//        testRowColNo()
//        testHorizontalNeighbors()
//        testVerticalNeighbors()
//        testIsValid()
        testGetFilteredNeighbors()
    }

    private fun testGetFilteredNeighbors() {
        unClickAllFireMatches()
        singleton.fireMatchesList!![2][0].alreadyClicked = true
        singleton.fireMatchesList!![1][0].alreadyClicked = true
        assertEquals(mainActivity.getFilteredNeighbors(singleton.fireMatchesList!![0][0]).size, 1)

        unClickAllFireMatches()
        singleton.fireMatchesList!![2][0].alreadyClicked = true
        singleton.fireMatchesList!![3][1].alreadyClicked = true
        assertEquals(mainActivity.getFilteredNeighbors(singleton.fireMatchesList!![4][1]).size, 3)

        unClickAllFireMatches()
        singleton.fireMatchesList!![4][2].alreadyClicked = true
        singleton.fireMatchesList!![4][3].alreadyClicked = true
        singleton.fireMatchesList!![5][4].alreadyClicked = true
        assertEquals(mainActivity.getFilteredNeighbors(singleton.fireMatchesList!![6][3]).size, 2)

        unClickAllFireMatches()
        singleton.fireMatchesList!![2][1].alreadyClicked = true
        singleton.fireMatchesList!![4][1].alreadyClicked = true
        singleton.fireMatchesList!![4][2].alreadyClicked = true
        assertEquals(mainActivity.getFilteredNeighbors(singleton.fireMatchesList!![2][2]).size, 2)

        unClickAllFireMatches()
        singleton.fireMatchesList!![0][2].alreadyClicked = true
        singleton.fireMatchesList!![2][2].alreadyClicked = true
        singleton.fireMatchesList!![2][3].alreadyClicked = true
        assertEquals(mainActivity.getFilteredNeighbors(singleton.fireMatchesList!![0][3]).size, 0)
    }

    private fun testIsValid() {
        unClickAllFireMatches()
        singleton.fireMatchesList!![3][2].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![2][1], singleton.fireMatchesList!![2][0]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![1][2].alreadyClicked = true
        assertTrue(mainActivity.isValid(singleton.fireMatchesList!![0][3], singleton.fireMatchesList!![1][4]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![6][1].alreadyClicked = true
        singleton.fireMatchesList!![4][1].alreadyClicked = true
        singleton.fireMatchesList!![2][1].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![4][0], singleton.fireMatchesList!![5][0]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![4][2].alreadyClicked = true
        singleton.fireMatchesList!![4][3].alreadyClicked = true
        assertTrue(mainActivity.isValid(singleton.fireMatchesList!![6][2], singleton.fireMatchesList!![6][3]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![7][4].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![8][3], singleton.fireMatchesList!![7][3]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![3][2].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![5][2], singleton.fireMatchesList!![6][1]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![1][2].alreadyClicked = true
        singleton.fireMatchesList!![3][2].alreadyClicked = true
        assertTrue(mainActivity.isValid(singleton.fireMatchesList!![1][1], singleton.fireMatchesList!![2][0]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![6][2].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![7][3], singleton.fireMatchesList!![8][2]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![7][1].alreadyClicked = true
        assertTrue(mainActivity.isValid(singleton.fireMatchesList!![7][0], singleton.fireMatchesList!![8][0]))

        unClickAllFireMatches()
        singleton.fireMatchesList!![4][3].alreadyClicked = true
        assertFalse(mainActivity.isValid(singleton.fireMatchesList!![3][4], singleton.fireMatchesList!![1][4]))
    }

    private fun testSetRowCol() {
        assertEquals(singleton.fireMatchesList!![0].size, 4)
        assertEquals(singleton.fireMatchesList!![1].size, 5)
        assertEquals(singleton.fireMatchesList!![2].size, 4)
        assertEquals(singleton.fireMatchesList!![3].size, 5)
        assertEquals(singleton.fireMatchesList!![4].size, 4)
        assertEquals(singleton.fireMatchesList!![5].size, 5)
        assertEquals(singleton.fireMatchesList!![6].size, 4)
        assertEquals(singleton.fireMatchesList!![7].size, 5)
        assertEquals(singleton.fireMatchesList!![8].size, 4)
    }

    private fun testRowColNo() {
        assertEquals(singleton.fireMatchesList!![0][0].rowNo, 0)
        assertEquals(singleton.fireMatchesList!![1][3].rowNo, 1)
        assertEquals(singleton.fireMatchesList!![2][1].rowNo, 2)
        assertEquals(singleton.fireMatchesList!![3][0].rowNo, 3)
        assertEquals(singleton.fireMatchesList!![4][2].rowNo, 4)

        assertEquals(singleton.fireMatchesList!![8][0].colNo, 0)
        assertEquals(singleton.fireMatchesList!![7][1].colNo, 1)
        assertEquals(singleton.fireMatchesList!![6][2].colNo, 2)
        assertEquals(singleton.fireMatchesList!![1][3].colNo, 3)
        assertEquals(singleton.fireMatchesList!![7][4].colNo, 4)
    }

    private fun testHorizontalNeighbors() {
        var horizontalNeighbors
                = arrayListOf(singleton.fireMatchesList!![2][0], singleton.fireMatchesList!![3][1],
                    singleton.fireMatchesList!![3][2], singleton.fireMatchesList!![1][1],
                    singleton.fireMatchesList!![1][2] , singleton.fireMatchesList!![2][2])
        assertEquals(mainActivity.getHorizontalNeighbors(singleton.fireMatchesList!![2][1]), horizontalNeighbors)

        horizontalNeighbors = arrayListOf(singleton.fireMatchesList!![1][0], singleton.fireMatchesList!![1][1],
            singleton.fireMatchesList!![0][1])
        assertEquals(mainActivity.getHorizontalNeighbors(singleton.fireMatchesList!![0][0]), horizontalNeighbors)

        horizontalNeighbors = arrayListOf(singleton.fireMatchesList!![5][0], singleton.fireMatchesList!![5][1],
            singleton.fireMatchesList!![3][0], singleton.fireMatchesList!![3][1], singleton.fireMatchesList!![4][1])
        assertEquals(mainActivity.getHorizontalNeighbors(singleton.fireMatchesList!![4][0]), horizontalNeighbors)

        horizontalNeighbors = arrayListOf(singleton.fireMatchesList!![8][2], singleton.fireMatchesList!![7][3],
            singleton.fireMatchesList!![7][4])
        assertEquals(mainActivity.getHorizontalNeighbors(singleton.fireMatchesList!![8][3]), horizontalNeighbors)

        horizontalNeighbors = arrayListOf(singleton.fireMatchesList!![8][2], singleton.fireMatchesList!![7][3],
            singleton.fireMatchesList!![7][4])
        assertEquals(mainActivity.getHorizontalNeighbors(singleton.fireMatchesList!![8][3]), horizontalNeighbors)
    }

    private fun testVerticalNeighbors() {
        var verticalNeighbors
                = arrayListOf(singleton.fireMatchesList!![3][2], singleton.fireMatchesList!![2][2],
            singleton.fireMatchesList!![2][1], singleton.fireMatchesList!![0][2], singleton.fireMatchesList!![0][1])
        assertEquals(mainActivity.getVerticalNeighbors(singleton.fireMatchesList!![1][2]), verticalNeighbors)

        verticalNeighbors = arrayListOf(singleton.fireMatchesList!![5][0], singleton.fireMatchesList!![4][0],
            singleton.fireMatchesList!![2][0], singleton.fireMatchesList!![1][0])
        assertEquals(mainActivity.getVerticalNeighbors(singleton.fireMatchesList!![3][0]), verticalNeighbors)

        verticalNeighbors = arrayListOf(singleton.fireMatchesList!![7][1], singleton.fireMatchesList!![6][1],
            singleton.fireMatchesList!![6][0], singleton.fireMatchesList!![4][1], singleton.fireMatchesList!![4][0],
            singleton.fireMatchesList!![3][1])
        assertEquals(mainActivity.getVerticalNeighbors(singleton.fireMatchesList!![5][1]), verticalNeighbors)

        verticalNeighbors = arrayListOf(singleton.fireMatchesList!![8][3], singleton.fireMatchesList!![6][3],
            singleton.fireMatchesList!![5][4])
        assertEquals(mainActivity.getVerticalNeighbors(singleton.fireMatchesList!![7][4]), verticalNeighbors)

        verticalNeighbors = arrayListOf(singleton.fireMatchesList!![5][3], singleton.fireMatchesList!![4][3],
            singleton.fireMatchesList!![4][2], singleton.fireMatchesList!![2][3], singleton.fireMatchesList!![2][2],
            singleton.fireMatchesList!![1][3])
        assertEquals(mainActivity.getVerticalNeighbors(singleton.fireMatchesList!![3][3]), verticalNeighbors)
    }

    private fun unClickAllFireMatches() {
        for (list in singleton.fireMatchesList!!) {
            for (fireMatch in list) {
                fireMatch.alreadyClicked = false
            }
        }
    }

}
