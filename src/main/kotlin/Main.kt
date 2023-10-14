import java.lang.Math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    oneTask()//класс теругольник с классами точек
}

fun oneTask(){
    class Dot (var x:Int, var y:Int){
        fun lenght (Dot:Dot):Double{
            return sqrt(pow(x.toDouble()-Dot.x,2.toDouble())+pow(y.toDouble()-Dot.y,2.toDouble()))
        }
    }
    class Trigon (val Dot1:Dot,val  Dot2:Dot,val Dot3:Dot){
        val Square = this.Square1()
        private fun Square1 ():Double{
            val len1 = Dot1.lenght(Dot2)
            val len2 = Dot2.lenght(Dot3)
            val len3 = Dot3.lenght(Dot1)
            val p:Double = (len1+len2+len3)/2
            return sqrt(p*(p-len1)*(p-len2)*(p-len3))
        }
        fun DotInTrigon (Dot:Dot,Tochnost:Double=0.000001):Boolean{
            val TriS1 = Trigon(Dot,Dot2,Dot3).Square
            val TriS2 = Trigon(Dot1,Dot,Dot3).Square
            val TriS3 = Trigon(Dot1,Dot2,Dot).Square
            val TriS = this.Square
            return TriS1+TriS2+TriS3<TriS+Tochnost && TriS1+TriS2+TriS3>TriS-Tochnost
        }
        constructor(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int):this(Dot(x1,y1),Dot(x2,y2),Dot(x3,y3)){
        }
        constructor(Dot1:Dot,x2:Int,y2:Int,x3:Int,y3:Int):this(Dot1.x,Dot1.y,x2,y2,x3,y3){
        }
    }


    val d1:Dot = Dot(1,2)
    val d2 = Dot(4,5)
    val d3 = Dot(5,2)
    val dIn = Dot(3,3)
    val dOut = Dot(2,5)
    val len1 = d1.lenght(d2)
    val len2 = d2.lenght(d3)
    val len3 = d3.lenght(d1)
    val tri1:Trigon = Trigon(d1,d2,d3)
    val tri2 = Trigon(1,1,2,2,3,4)
    val TriS = tri1.Square
    val R = (len1 * len2 * len3) / (4 * TriS)
//    x = ((b^2 + c^2 - a^2) / (2 * b * c)) * x1 + ((c^2 + a^2 - b^2) / (2 * c * a)) * x2 + ((a^2 + b^2 - c^2) / (2 * a * b)) * x3
//    val xCirc = ((pow(len2,2.0) ))
//    y = ((b^2 + c^2 - a^2) / (2 * b * c)) * y1 + ((c^2 + a^2 - b^2) / (2 * c * a)) * y2 + ((a^2 + b^2 - c^2) / (2 * a * b)) * y3
    println("Длина между точками ${d1.x} ${d1.y} и ${d2.x} ${d2.y} равна ${len1}")
    println("Длина между точками ${d2.x} ${d2.y} и ${d3.x} ${d3.y} равна ${len2}")
    println("Длина между точками ${d3.x} ${d3.y} и ${d1.x} ${d1.y} равна ${len3}")
    println("Площадь треугольника с точками ${d1.x} ${d1.y}, ${d2.x} ${d2.y} и ${d3.x} ${d3.y} равна ${TriS}")
    if (tri1.DotInTrigon(dIn,0.0001)){
        println("Точка ${dIn.x} ${dIn.y} находится в треугольнике с точками ${d1.x} ${d1.y}, ${d2.x} ${d2.y} и ${d3.x} ${d3.y}")
    }
    else{
        println("Точка ${dIn.x} ${dIn.y} не находится в треугольнике с точками ${d1.x} ${d1.y}, ${d2.x} ${d2.y} и ${d3.x} ${d3.y}")
    }
    if (tri1.DotInTrigon(dOut,0.0001)){
        println("Точка ${dOut.x} ${dOut.y} находится в треугольнике с точками ${d1.x} ${d1.y}, ${d2.x} ${d2.y} и ${d3.x} ${d3.y}")
    }
    else{
        println("Точка ${dOut.x} ${dOut.y} не находится в треугольнике с точками ${d1.x} ${d1.y}, ${d2.x} ${d2.y} и ${d3.x} ${d3.y}")
    }

}