fun haveLetter(str:List<String>):Boolean{//есть ли буквы в листе
    for (i in ('A'..'Z') + ('a'..'z')+('А'..'Я')+('а'..'я')+'ё'+'Ё')
        if (i in str.toString()){
            return true
        }
    return false
}
fun printDot (Map:MutableMap<String,Dot>){//вывод имеющихся точек из словаря
    if (Map.size !=0){
        println("Есть такие точки:")
        for (i in Map.keys){
            print("${i} ")
        }
        println()
    }
    else{
        println("Точек нет")
    }
}
fun printTri (Map:MutableMap<String,Trigon>){//вывод имеющихся теугольников из словаря
    if (Map.size !=0){
        println("Есть такие точки:")
        for (i in Map.keys){
            print("${i} ")
        }
        println()
    }
    else{
        println("Точек нет")
    }
}
fun maxLengt (vararg dots:Dot):Double{
    var max:Double = 0.0
    if(dots.size<2){
        println("Количество точек меньше 3")
        return 0.0
    }
    else
    {
        for (i in dots){
            for (j in dots){
                if (i != j && max < i.lenght(j) ){
                    max = i.lenght(j)
                }
            }
        }
    }
    return max
}
fun minLengt (vararg dots:Dot):Double{
    if(dots.size<2){
        println("Количество точек меньше 3")
        return 0.0
    }
    else
    {
        var min:Double = dots[0].lenght(dots[1])
        for (i in dots){
            for (j in dots){
                if (i != j && min > i.lenght(j) ){
                    min = i.lenght(j)
                }
            }
        }
        return min
    }
}