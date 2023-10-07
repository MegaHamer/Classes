fun main(args: Array<String>) {
    oneTask()//класс теругольник с классами точек
}

fun oneTask(){
    class Dot (var x:Int,var y:Int){
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
    }
    class Trigon {
        constructor(Dot1:Dot,Dot2:Dot,Dot3:Dot){

        }
        constructor(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int){

        }
        fun DotInTrigon(Dot:Dot){

        }
        fun Square (){

        }
    }


    val d1:Dot = Dot(1,2)
    val d2 = Dot(4,5)
    val d3 = Dot(5,2)
    val tri1:Trigon = Trigon(d1,d2,d3)
    val tri2:Trigon = Trigon(1,2,4,5,5,2)
    println("${tri1.Dot1}")
}