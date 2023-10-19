import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class TrigonTest {

    @ParameterizedTest(name = "[{index}] Trigon({0}, {1}, {2}, {3}, {4}, {5}) expected {6}")
    @CsvSource(
        "2,8,5,3,10,7,5.9",
        "-6,3,5,1,-1,-2,-0.166"
    )
    fun getOutCirleX(x1:Double,y1:Double,x2:Double,y2:Double,x3:Double,y3:Double,expected:Double) {
        val a =Trigon(x1,y1,x2,y2,x3,y3)
        //val expected = 6.0
        val actual = a.outCirle.x
        assertEquals(expected,actual,0.1)
    }
    @ParameterizedTest(name = "[{index}] Trigon({0}, {1}, {2}, {3}, {4}, {5}) expected {6}")
    @CsvSource(
            "2,8,5,3,10,7,7",
            "-6,3,5,1,-1,-2,3.84"
    )
    fun getOutCirleY(x1:Double,y1:Double,x2:Double,y2:Double,x3:Double,y3:Double,expected:Double) {
        val a =Trigon(x1,y1,x2,y2,x3,y3)
        //val expected:Double = 7.0
        val actual = a.outCirle.y
        assertEquals(expected,actual,0.1,"expect ${expected}_return ${actual}")
    }
    @Test
    fun getOutCirleX1() {
        val a =Trigon(-6,3,5,1,-1,-2)
        val expected = -0.166
        val actual = a.outCirle.x
        assertEquals(expected,actual,0.01)
    }
    @Test
    fun getOutCirleY1() {
        val a =Trigon(-6,3,5,1,-1,-2)
        val expected:Double = 3.84
        val actual = a.outCirle.y
        assertEquals(expected,actual,0.1,"expect ${expected}_return ${actual}")
    }
    @org.junit.jupiter.api.Test
    fun getInCircle() {
    }

}