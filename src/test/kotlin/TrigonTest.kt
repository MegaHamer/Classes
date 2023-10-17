import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrigonTest {

    @org.junit.jupiter.api.Test
    fun getOutCirleX() {
        val a =Trigon(2,8,5,3,10,7)
        val expected = 6.0
        val actual = a.outCirle.x
        assertEquals(expected,actual,0.1)
    }
    @Test
    fun getOutCirleX1() {
        val a =Trigon(-6,3,5,1,-1,-2)
        val expected = -0.166
        val actual = a.outCirle.x
        assertEquals(expected,actual,0.01)
    }
    @org.junit.jupiter.api.Test
    fun getOutCirleY() {
        val a =Trigon(2,8,5,3,10,7)
        val expected:Double = 7.0
        val actual = a.outCirle.y
        assertEquals(expected,actual,0.1,"expect ${expected}_return ${actual}")
    }

    @org.junit.jupiter.api.Test
    fun getInCircle() {
    }
}