import kotlin.math.sqrt

class Dot (var x:Double=0.0, var y:Double=0.0){
    constructor(x:Int,y:Int):this(x.toDouble(),y.toDouble()){}
    constructor(x: Int,y: Double):this(x.toDouble(),y){}
    constructor(x: Double,y: Int):this(x,y.toDouble()){}
    fun lenght (Dot:Dot):Double{
        return sqrt(Math.pow(x-Dot.x,2.toDouble()) + Math.pow(y-Dot.y,2.toDouble()))
    }
    fun k(Dot:Dot):Double{
        if(this.x!=Dot.x){
            return (this.y-Dot.y)/(this.x-Dot.x)
        }
        else{
            return 1.0
        }
    }
}