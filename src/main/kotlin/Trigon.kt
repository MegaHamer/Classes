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

}