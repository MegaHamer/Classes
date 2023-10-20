import java.lang.Math.pow
import kotlin.math.sqrt

class Trigon (var Dot1:Dot, var  Dot2:Dot, var Dot3:Dot){
    constructor(x1:Double,y1:Double,x2:Double,y2:Double,x3:Double,y3:Double):this(Dot(x1,y1),Dot(x2,y2),Dot(x3,y3)){}
    constructor(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int):this(x1.toDouble(),y1.toDouble(),x2.toDouble(),y2.toDouble(),x3.toDouble(),y3.toDouble()){}
    constructor(Dot1:Dot,x2:Double,y2:Double,x3:Double,y3:Double):this(Dot1.x,Dot1.y,x2,y2,x3,y3){}
    constructor(Dot1:Dot,x2:Int,y2:Int,x3:Int,y3:Int):this(Dot1.x.toDouble(),Dot1.y.toDouble(),x2.toDouble(),y2.toDouble(),x3.toDouble(),y3.toDouble()){}
    constructor(x1:Double,y1:Double,Dot2: Dot,x3:Double,y3:Double):this(x1,y1,Dot2.x,Dot2.y,x3,y3){}
    constructor(x1:Int,y1:Int,Dot2: Dot,x3:Int,y3:Int):this(x1.toDouble(),y1.toDouble(),Dot2.x.toDouble(),Dot2.y.toDouble(),x3.toDouble(),y3.toDouble()){}
    constructor(x1:Double,y1:Double,x2:Double,y2:Double,Dot3: Dot):this(x1,y1,x2,y2,Dot3.x,Dot3.y){}
    constructor(x1:Int,y1:Int,x2:Int,y2:Int,Dot3: Dot):this(x1.toDouble(),y1.toDouble(),x2.toDouble(),y2.toDouble(),Dot3.x.toDouble(),Dot3.y.toDouble()){}
    constructor(Dot1:Dot,Dot2: Dot,x3:Double,y3:Double):this(Dot1.x,Dot1.y,Dot2.x,Dot2.y,x3,y3){}
    constructor(Dot1:Dot,Dot2: Dot,x3:Int,y3:Int):this(Dot1.x.toDouble(),Dot1.y.toDouble(),Dot2.x.toDouble(),Dot2.y.toDouble(),x3.toDouble(),y3.toDouble()){}
    constructor(x1:Double,y1:Double,Dot2: Dot,Dot3: Dot):this(x1,y1,Dot2.x,Dot2.y,Dot3.x,Dot3.y){}
    constructor(x1:Int,y1:Int,Dot2: Dot,Dot3: Dot):this(x1.toDouble(),y1.toDouble(),Dot2.x.toDouble(),Dot2.y.toDouble(),Dot3.x.toDouble(),Dot3.y.toDouble()){}
    constructor(Dot1:Dot,x2:Double,y2:Double,Dot3: Dot):this(Dot1.x,Dot1.y,x2,y2,Dot3.x,Dot3.y){}
    constructor(Dot1:Dot,x2:Int,y2:Int,Dot3: Dot):this(Dot1.x.toDouble(),Dot1.y.toDouble(),x2.toDouble(),y2.toDouble(),Dot3.x.toDouble(),Dot3.y.toDouble()){}
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
    val outCirle =Dot(outCircleX(),outCircleY());
    val inCircle =Dot(inCircleX(),inCircleY());
    val outCircleRadius = outCirle.lenght(Dot1)
    val inCircleRadius:Double = inCircleRadius();
    private fun outCircleX():Double{
        val mid1 = Dot(Dot1.x+(Dot2.x-Dot1.x)/2,Dot1.y+(Dot2.y-Dot1.y)/2)
        val mid2 = Dot(Dot1.x+(Dot3.x-Dot1.x)/2,Dot1.y+(Dot3.y-Dot1.y)/2)
        val k1 = -1/Dot1.k(Dot2)
        val k2 = -1/Dot1.k(Dot3)
        val b1 = Dot(0,mid1.y-k1*mid1.x)
        val b2 = Dot(0,mid2.y-k2*mid2.x)
        if(b2.y == mid2.y){
            b2.x += 3.0
        }
        return xFind(mid1,b1,mid2,b2)
    }
    private fun outCircleY():Double{
        val mid1 = Dot(Dot1.x+(Dot2.x-Dot1.x)/2,Dot1.y+(Dot2.y-Dot1.y)/2)
        var k1 = -1/Dot1.k(Dot2)
        if( mid1.x <= outCircleX()+0.1 && mid1.x >= outCircleX() -0.1){
            mid1.x = Dot1.x+(Dot3.x-Dot1.x)/2
            mid1.y= Dot1.y+(Dot3.y-Dot1.y)/2
            k1 = -1/Dot1.k(Dot3)
        }
        val b1 = Dot(0,mid1.y-k1*mid1.x)
        if(b1.y == mid1.y){
            b1.x += 3.0
        }
        val res = yFind(outCircleX(),mid1,b1)
        return res
    }
    private  fun inCircleX():Double{
        //Точка на прямой на расстоянии n
        fun dotOnNRange(d1: Dot,d2: Dot,n:Double=10.0):Dot{
            val k = d1.k(d2)
            val gip = sqrt(pow(k,2.0)+1)
            val b = d1.y-k*d1.x
            val x:Double
            if (d1.x<d2.x){
                x= n/gip+d1.x
            }
            else{
                x= -n/gip+d1.x
            }
            val y = k*x+b
            return Dot(x,y)
        }
        fun outCircleDot(Dt1:Dot,Dt2:Dot,Dt3:Dot):Dot{
            val mid1 = Dot(Dt1.x+(Dt2.x-Dt1.x)/2,Dt1.y+(Dt2.y-Dt1.y)/2)
            val mid2 = Dot(Dt1.x+(Dt3.x-Dt1.x)/2,Dt1.y+(Dt3.y-Dt1.y)/2)
            val k1 = -1/Dt1.k(Dt2)
            val k2 = -1/Dt1.k(Dt3)
            val b1 = Dot(0,mid1.y-k1*mid1.x)
            val b2 = Dot(0,mid2.y-k2*mid2.x)
            val x = xFind(mid1,b1,mid2,b2)
            val y = yFind(x,mid1,b1)
            return Dot(x,y)
        }
        val bisDotForDot1 = outCircleDot(Dot1,dotOnNRange(Dot1,Dot2),dotOnNRange(Dot1,Dot3))
        val bisDotForDot2 = outCircleDot(Dot2,dotOnNRange(Dot2,Dot1),dotOnNRange(Dot2,Dot3))

        return xFind(Dot1,bisDotForDot1,Dot2,bisDotForDot2)
    }
    private fun inCircleY():Double{
        fun dotOnNRange(d1: Dot,d2: Dot,n:Double=10.0):Dot{
            val k = d1.k(d2)
            val gip = sqrt(pow(k,2.0)+1)
            val b = d1.y-k*d1.x
            val x:Double
            if (d1.x<d2.x){
                x= n/gip+d1.x
            }
            else{
                x= -n/gip+d1.x
            }
            val y = k*x+b
            return Dot(x,y)
        }
        fun outCircleDot(Dt1:Dot,Dt2:Dot,Dt3:Dot):Dot{
            val mid1 = Dot(Dt1.x+(Dt2.x-Dt1.x)/2,Dt1.y+(Dt2.y-Dt1.y)/2)
            val mid2 = Dot(Dt1.x+(Dt3.x-Dt1.x)/2,Dt1.y+(Dt3.y-Dt1.y)/2)
            val k1 = -1/Dt1.k(Dt2)
            val k2 = -1/Dt1.k(Dt3)
            val b1 = Dot(0,mid1.y-k1*mid1.x)
            val b2 = Dot(0,mid2.y-k2*mid2.x)
            val x = xFind(mid1,b1,mid2,b2)
            val y = yFind(x,mid1,b1)
            return Dot(x,y)
        }
        val bisDotForDot1 = outCircleDot(Dot1,dotOnNRange(Dot1,Dot2),dotOnNRange(Dot1,Dot3))
        return yFind(inCircleX(),Dot1,bisDotForDot1)
    }

    private fun inCircleRadius():Double{
        val d = inCircle //точка окр
        val k = -1/Dot1.k(Dot2)//k высоты до точки окр
        val b = Dot(0,d.y-k*d.x) // точка на оси ординат
        if(b.y == d.y){ //если точки на одной плоскости (и возможно одинаковы)
            b.x += d.y+ 3.0
        }
        val tx = xFind(b,d,Dot1,Dot2) // Х точки пересечения прямых
        val t = Dot(tx,yFind(tx,b,d)) //точка пересечения прямых

        return d.lenght(t)
    }

    private fun xFind(d1: Dot,d2: Dot,d3: Dot,d4: Dot):Double{
        return (d1.x*(d2.y-d1.y)/(d2.x-d1.x) - d3.x*(d4.y-d3.y)/(d4.x-d3.x) + d3.y -d1.y )/( (d2.y-d1.y)/(d2.x-d1.x) - (d4.y-d3.y)/(d4.x-d3.x) )
    }
    private fun yFind(x:Double,d1:Dot,d2:Dot):Double{
        return (x-d1.x)/(d2.x-d1.x)*(d2.y-d1.y)+d1.y
    }
}