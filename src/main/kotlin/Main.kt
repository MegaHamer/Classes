import java.lang.Math.pow
import java.lang.Math.powerOfTwoD
import kotlin.math.sqrt

fun main(args: Array<String>) {
    oneTask()//класс теругольник с классами точек
}

fun oneTask(){
    class Dot (private var x:Int,private var y:Int){
        fun set (NewX:Int,NewY:Int){
            x=NewX
            y=NewY
        }
        fun setX (NewX:Int){
            x=NewX
        }
        fun setY (NewY:Int){
            y=NewY
        }
        fun X():Int {
            return x
        }
        fun Y():Int {
            return y
        }
        fun lenght (Dot:Dot):Double{
            return sqrt(pow(x.toDouble()-Dot.x,2.toDouble())+pow(y.toDouble()-Dot.y,2.toDouble()))
        }
    }
    class Trigon (val Dot1:Dot,val  Dot2:Dot,val Dot3:Dot){
        fun Square ():Double{
            val len1 = Dot1.lenght(Dot2)
            val len2 = Dot2.lenght(Dot3)
            val len3 = Dot3.lenght(Dot1)
            val p:Double = (len1+len2+len3)/2
            return sqrt(p*(p-len1)*(p-len2)*(p-len3))
        }
        fun DotInTrigon (Dot:Dot,Tochnost:Double):Boolean{
            val TriS1 = Trigon(Dot,Dot2,Dot3).Square()
            val TriS2 = Trigon(Dot1,Dot,Dot3).Square()
            val TriS3 = Trigon(Dot1,Dot2,Dot).Square()
            val TriS = this.Square()
            return TriS1+TriS2+TriS3<TriS+Tochnost && TriS1+TriS2+TriS3>TriS-Tochnost
        }
    }

 /*       constructor(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int){
            val Dot1 = Dot(x1,y1)
            val Dot2 = Dot(x2,y2)
            val Dot3 = Dot(x3,y3)
            fun Square2 ():Double{
                val len1 = Dot1.lenght(Dot2)
                val len2 = Dot2.lenght(Dot3)
                val len3 = Dot3.lenght(Dot1)
                val p:Double = (len1+len2+len3)/2
                return sqrt(p*(p-len1)*(p-len2)*(p-len3))
            }
        }

    }
*/

    val d1:Dot = Dot(1,2)
    val d2 = Dot(4,5)
    val d3 = Dot(5,2)
    val dIn = Dot(3,3)
    val dOut = Dot(2,5)
    val len1 = d1.lenght(d2)
    val len2 = d2.lenght(d3)
    val len3 = d3.lenght(d1)
    val tri1:Trigon = Trigon(d1,d2,d3)
    val Tris = tri1.Square()
    val R = (len1 * len2 * len3) / (4 * Tris)
    x = ((b^2 + c^2 - a^2) / (2 * b * c)) * x1 + ((c^2 + a^2 - b^2) / (2 * c * a)) * x2 + ((a^2 + b^2 - c^2) / (2 * a * b)) * x3
    val xCirc = ((pow(len2,2.0) ))
    y = ((b^2 + c^2 - a^2) / (2 * b * c)) * y1 + ((c^2 + a^2 - b^2) / (2 * c * a)) * y2 + ((a^2 + b^2 - c^2) / (2 * a * b)) * y3
    println("Длина между точками ${d1.X()} ${d1.Y()} и ${d2.X()} ${d2.Y()} равна ${len1}")
    println("Длина между точками ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()} равна ${len2}")
    println("Длина между точками ${d3.X()} ${d3.Y()} и ${d1.X()} ${d1.Y()} равна ${len3}")
    println("Площадь треугольника с точками ${d1.X()} ${d1.Y()}, ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()} равна ${TriS}")
    if (tri1.DotInTrigon(dIn,0.0001)){
        println("Точка ${dIn.X()} ${dIn.Y()} находится в треугольнике с точками ${d1.X()} ${d1.Y()}, ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()}")
    }
    else{
        println("Точка ${dIn.X()} ${dIn.Y()} не находится в треугольнике с точками ${d1.X()} ${d1.Y()}, ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()}")
    }
    if (tri1.DotInTrigon(dOut,0.0001)){
        println("Точка ${dOut.X()} ${dOut.Y()} находится в треугольнике с точками ${d1.X()} ${d1.Y()}, ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()}")
    }
    else{
        println("Точка ${dOut.X()} ${dOut.Y()} не находится в треугольнике с точками ${d1.X()} ${d1.Y()}, ${d2.X()} ${d2.Y()} и ${d3.X()} ${d3.Y()}")
    }


}