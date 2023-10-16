import java.lang.Math.pow
import kotlin.math.sqrt
fun main() {
    val ArrDot = mutableMapOf("A" to Dot(2,8),"B" to Dot(5,3),"C" to Dot(10,7),"D" to Dot(-6,3),"E" to Dot(5,1),"F" to Dot(-1,-2))
    val ArrTri:MutableMap<String,Trigon> = mutableMapOf()
    ArrTri+=("ABC" to Trigon(ArrDot["A"]!!, ArrDot["B"]!!, ArrDot["C"]!!))
    ArrTri.put("DEF",Trigon(ArrDot["D"]!!,ArrDot["E"]!!,ArrDot["F"]!!))
    while (true) {
        println("Выберите область работы:\n1.Точки\n2.Треугольники\n3 или /.Выход")
        when (readln()) {
            "1" -> {
                //Посмотреть имеющиеся точку или точки на выбор, по умолчанию есть несколько+
                //Посмотреть на длину между 2 точками+
                //Узнать самую большую и маленькую длинны между 3 и более точками на выбор+-
                //Изменить имеющуюся точку или точки на выбор+
                //Создать новую точку или точки+
                //Удалить точку или точки на выбор+
                //Выход+
                while (true) {
                    println(
                        "\n\n./Точки\nВыберите дествие:\n" +
                                "1.Посмотреть имеющиеся точку или точки на выбор\n" +
                                "2.Посмотреть на длину между двумя точками\n" +
                                "3.Узнать самую большую и маленькую длинны между 3 и более точками на выбор\n" +
                                "4.Изменить имеющуюся точку или точки на выбор\n" +
                                "5.Создать новую точку или точки\n" +
                                "6.Удалить точку или точки на выбор\n" +
                                "7 или /.Выход\n"
                    )
                    when (readln()) {
                        "1" -> { //Посмотреть имеющиеся точку или точки на выбор, по умолчанию есть несколько+
                            while(true){
                                println("\n\n./Точки/Список точек")
                                if (ArrDot.size !=0){
                                    println("Есть такие точки:")
                                    for (i in ArrDot.keys){
                                        print("${i} ")
                                    }
                                    println()
                                }
                                else{
                                    println("Точек нет")
                                }
                                println("Выберите дейстиве:\n1.Посмотреть координаты точки\n2 или /.Выход")
                                when(readln()){
                                    "1"->{
                                        println("\n\n./Точки/Список точек/Координаты")
                                        if (ArrDot.size !=0){
                                            println("Есть такие точки:")
                                            for (i in ArrDot.keys){
                                                print("${i} ")
                                            }
                                            println()
                                        }
                                        else{
                                            println("Точек нет")
                                            continue
                                        }
                                        println("Выберите точку(-и) которую(-ые) вы хотите посмотреть через пробел \n(или посмотреть все вводом 'Все')")
                                        val cc = readln().split(" ")

                                        if ("Все" in cc){
                                            for (j in ArrDot.keys){
                                                println("Координаты точки ${j} (${ArrDot[j]!!.x};${ArrDot[j]!!.y})")
                                            }
                                            continue
                                        }
                                        else
                                        for (i in cc){
                                            if (i in ArrDot.keys){
                                                println("Координаты точки ${i} (${ArrDot[i]!!.x};${ArrDot[i]!!.y})")
                                            }
                                            else{
                                                println("Точки ${i} не существует")
                                            }
                                        }
                                    }
                                    "2","/"->{break}
                                    else-> println("Такого варианта нет")
                                }
                            }


                        }
                        "2" -> { //Посмотреть на длину между 2 точками+
                            while(true){
                                println("\n\n./Точки/Расстояние между точками")
                                if (ArrDot.size !=0){
                                    println("Есть такие точки:")
                                    for (i in ArrDot.keys){
                                        print("${i} ")
                                    }
                                    println()
                                }
                                else{
                                    println("Точек нет")
                                }
                                println("Введите две точки через пробел (для выхода '/')")
                                println("или точки вида '1;2' через пробел")
                                val cc = readln().split(" ")
                                if ('/' in cc.joinToString("").toCharArray()){
                                    break
                                }
                                var dot:Array<Dot> = arrayOf()//точки между которыми будет измерятся расстояние
                                for (i in cc){//получаю точки
                                    if (i in ArrDot.keys){//есть точка в списке
                                        if (dot.size ==0){
                                            dot += ArrDot[i]!!
                                        }
                                        else{
                                            dot += ArrDot[i]!!
                                        }
                                    }
                                    else{
                                        if (';' in i.toCharArray()){//точка из x и y
                                            val digits = i.split(";")
                                            if (dot.size == 0){
                                                dot += Dot(digits[0].toDouble(),digits[1].toDouble())
                                            }
                                            else{
                                                dot += Dot(digits[0].toDouble(),digits[1].toDouble())
                                            }
                                        }
                                        else{//точки нет в списке или неправильно ввели
                                            println("Такой точки нет или вы неверно указали")
                                            break
                                        }
                                    }
                                }
                                if (dot.size>=2)
                                println("Длинна между точками ${dot[0].x};${dot[0].y} и ${dot[1].x};${dot[1].y} равна ${dot[0].lenght(dot[1])}")
                            }
                        }
                        "3" -> {  //Узнать самую большую и маленькую длинны между 3 и более точками на выбор+-
                            var dd:Array<Dot> = arrayOf()//массив точек для передачи в фунции
                            while(true){
                                println("\n\n./Точки/Большая маленькая")
                                if (ArrDot.size !=0){
                                    println("Есть такие точки:")
                                    for (i in ArrDot.keys){
                                        print("${i} (${ArrDot[i]!!.x};${ArrDot[i]!!.y})  ")
                                    }
                                    println()
                                }
                                else{
                                    println("Точек нет")
                                }
                                println("Точки участвующие в вычислении: ")
                                for (j in dd){
                                    print(" (${j.x};${j.y}) ")
                                }
                                println()
                                println("Введите точки из списка или в формате '1;2'(более 2)")
                                println("Для вывода результата самой большой и маленьких длинн между точками введите '='")
                                //println("Очистить список точек участвующих в вычислении - '*'")
                                println("Выход - '/'")
                                val cc = readln().split(" ")
                                if ('/' in cc.joinToString("").toCharArray()){
                                    break
                                }
                                /*if ('*' in cc.joinToString("").toCharArray()){
                                    println("ddddefe")
                                    dd=arrayOf()
                                }*/
                                if ('=' in cc.joinToString("").toCharArray()){
                                    if (dd.size<3){
                                        println("Недостаточкно точек")
                                    }
                                    else{
                                        print("Точки: ")
                                        for (j in dd){
                                            print(" (${j.x};${j.y}) ")
                                        }
                                        println()
                                        println("Самая большая длинна между точками: ${maxLengt(*dd)}")
                                        println("Самая маленькая длинна между точками: ${minLengt(*dd)}")
                                    }
                                    continue
                                }
                                for (i in cc){
                                    if (i in ArrDot.keys){
                                        dd+=(ArrDot[i]!!)
                                    }
                                    else{
                                        if ( haveLetter( listOf(i) ) ){
                                            println("Точки ${i} нет")
                                        }
                                        else{
                                            val cords = i.split(";")
                                            dd+=( Dot( cords[0].toDouble(),cords[1].toDouble() ) )
                                        }
                                    }
                                }

                            }
                        }
                        "4" -> { //Изменить имеющуюся точку или точки на выбор+
                            while(true){
                                println("\n\n./Точки/Изменить точки")
                                if (ArrDot.size !=0){
                                    println("Есть такие точки:")
                                    for (i in ArrDot.keys){
                                        print("${i} ")
                                    }
                                    println()
                                    println("Введите точку(-и), которые вы хотите изменить через пробел \n(выход- '/')")
                                    val cc = readln().split(" ")
                                    if ('/' in cc.joinToString("").toCharArray()){
                                        break
                                    }
                                    var leave = false
                                    for (i in cc){
                                        if (leave){
                                            break
                                        }
                                        var boo = true
                                        while (boo){
                                            if (i in ArrDot.keys){
                                                println("Точка ${i} (${ArrDot[i]!!.x};${ArrDot[i]!!.y})")
                                                println("Введите новые координаты точки через пробел (скип - '*', закончить - '/')")
                                                val pp = readln().split(" ")
                                                if (haveLetter(pp)){
                                                    println("Неправильно введены координаты")
                                                    continue
                                                }
                                                if ('*' in pp.joinToString().toCharArray()){
                                                    break
                                                }
                                                if ('/' in cc.joinToString("").toCharArray()){
                                                    leave=true
                                                    break
                                                }
                                                if (pp.size >1){
                                                    ArrDot[i]!!.x=pp[0].toDouble()
                                                    ArrDot[i]!!.y=pp[1].toDouble()
                                                    boo=false
                                                }
                                                else {
                                                    println("Недостаточно координат")
                                                }
                                            }
                                            else {
                                                println("Точки ${i} нет")
                                                boo=false
                                            }
                                        }
                                    }
                                }
                                else{
                                    println("Точек нет")
                                    break
                                }

                            }
                        }
                        "5" -> {//Создать новую точку или точки+
                            while(true){
                                println("\n\n./Точки/Создать")
                                printDot(ArrDot)
                                if (ArrDot.size>0){
                                    println("Введите имя(имена) точки(-ек) для создания, через пробел")
                                    println("Выход - '/'")
                                    val cc = readln().split(" ")
                                    if ('/' in cc.joinToString("").toCharArray()){
                                        break
                                    }
                                    var leave=false
                                    for (i in cc){
                                        if (leave){
                                            break
                                        }
                                        while (true){
                                            if (i in ArrDot.keys){
                                                println("Точка с именем ${i} уже есть")
                                                break
                                            }
                                            else{
                                                println("Введите координаты точке ${i} через пробел")
                                                println("Скип - '*' Выход - '/'")
                                                val kk = readln().split(" ")
                                                if ('/' in kk.joinToString("").toCharArray()){
                                                    leave=true
                                                    break
                                                }
                                                if ('*' in kk.joinToString("").toCharArray()){
                                                    break
                                                }
                                                if (haveLetter(kk)){
                                                    println("Координаты введены неверно")
                                                    continue
                                                }
                                                else{
                                                    ArrDot.put(i,Dot(kk[0].toDouble(),kk[1].toDouble()))
                                                    break
                                                }
                                            }
                                        }

                                    }
                                }
                                else{
                                    break
                                }
                            }
                        }
                        "6" -> { //Удалить точку или точки на выбор+
                            while(true){
                                println("\n\n./Точки/Удалить")
                                printDot(ArrDot)
                                if (ArrDot.size>0){
                                    println("Введите точку(-и) для удаления через пробел")
                                    println("Удалить все точки - 'Все'")
                                    println("Выход - '/'")
                                    val cc = readln().split(" ")
                                    if ('/' in cc.joinToString("").toCharArray()){
                                        break
                                    }
                                    if ("Все" in cc){
                                            ArrDot.clear()
                                        continue
                                    }
                                    for (i in cc){
                                        if (i in ArrDot.keys){
                                            println("Точка ${i} (${ArrDot[i]!!.x};${ArrDot[i]!!.y}) далена")
                                            ArrDot.remove(i)
                                        }
                                        else{
                                            println("Точки ${i} нет")
                                        }
                                    }
                                }
                                else{
                                    break
                                }
                            }
                        }
                        "7","/" -> {break}

                        else -> println("Такого варианта нет")
                    }
                }
            }

            "2" -> {
                //Посмотреть имеющиеся треугольники, по умолчанию есть 2
                //Узнать входит ли точка в треугольник
                //Узнать центр описанной окружности
                //Узнать центр выписанной окружности
                //Изменить имеющийся треугольник(его координаты) на выбор
                //Добавить треугольник
                //Удалить треугольники на выбор
                //Выход
                while (true){
                    println(
                        "\n\n./Теугольники\nВыберите дествие:\n" +
                                "1.Посмотреть имеющиеся треугольники\n" +
                                "2.Узнать входит ли точка в треугольник\n" +
                                "3.Узнать центр описанной окружности\n" +
                                "4.Узнать центр выписанной окружности\n" +
                                "5.Изменить имеющийся треугольник(его координаты) на выбор\n" +
                                "6.Добавить треугольник\n" +
                                "7.Удалить треугольники на выбор\n" +
                                "8 или /.Выход\n"
                    )
                    when (readln()) {
                        "1" -> {}
                        "2" -> {}
                        "3" -> {}
                        "4" -> {}
                        "5" -> {}
                        "6" -> {}
                        "7" -> {}
                        "8","/" -> {break}

                        else -> println("Такого варианта нет")
                    }
                }
            }

            "3","/" -> {break}

            else -> println("Такого варианта нет")
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