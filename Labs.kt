import java.util.*
import kotlin.math.abs
import kotlin.random.Random

class LabFirstNumber_19 {
    // 19. Пользователь вводит числа х, a, b. Из промежутка от a до b
    // найти все числа, разность цифр которых по модулю дает х.
    val a: Int
    val b: Int
    val x: Int
    var numbers: Int = 0

    constructor() {
        println("\nЛАБА 1 ЗАДАНИЕ 19")
        // Вводим данные:
        println("Введите а: ")
        a = readLine()!!.toInt()

        println("Введите b: ")
        b = readLine()!!.toInt()

        println("Введите x: ")
        x = readLine()!!.toInt()

        // Находим разность цифр в промежутке:
        for (i in a..b) {
            var i_while = i;
            while (i_while > 0) {
                numbers -= i_while % 10
                i_while /= 10
            }
            if (abs(x) == abs(numbers))
                println("Разность цифр числа - $i по модулю дает $x ")
            numbers = 0;
        }
    }

}

class LabFirstNumber_9 {
    // 9. Дано натуральное число N. Найти и вывести все числа в интервале от 1 до N–1, у которых произведение
    //всех цифр совпадает с произведением цифр данного числа. Если таких чисел нет, то вывести слово «нет».
    //Пример. N = 32. Числа: 6, 16, 23.
    var N: Int
    var numberForN: Int = 1
    var numbersForInterval: Int = 1

    constructor() {
        println("\nЛАБА 1 ЗАДАНИЕ 9")
        // Вводим данные:
        println("Введите N: ")
        N = readLine()!!.toInt()

        // находим все цифры числа N:
        var while_N = N;
        while (while_N > 0) {
            numberForN *= while_N % 10
            while_N /= 10
        }

        // Находим цифры из чисел заданного промежутка:
        for (i in 1..N - 1) {
            var i_while = i;
            while (i_while > 0) {
                numbersForInterval *= i_while % 10
                i_while /= 10
            }

            if (numbersForInterval == numberForN)
                println("Произведение цифр числа - $N равно произведению цифрам числа  $i ")
            numbersForInterval = 1;
        }
    }
}

class LabSecondNumber_19 {
    //Дан целочисленный массив с количеством элементов n.
//Сжать массив, выбросив из него каждый второй
//элемент.
    constructor() {

        // Создаем массив:
        print("Введите количество элементов массива: ")
        var n = readLine()!!.toInt();
        var array = IntArray(n, { Random.nextInt(10) })
        println("массив:")
        array.forEach { print(" $it ") }

        // Сортируем согласно условию:
        println("\nПреобразованный массив:")
        var i = 0;
        for (it in array) if (!(((i++) + 1) % 2 == 0)) print("$it ")
    }
}

class LabSecondNumber_7 {
    // Сформировать одномерный массив из целых чисел.
// Вывести на экран индексы тех элементов, которые кратны
//трем и пяти.
    constructor() {

        // Создаем массив:
        print("Введите количество элементов массива: ")
        var n = readLine()!!.toInt();
        var array = IntArray(n, { Random.nextInt(100) })
        println("Массив:")
        array.forEach { print(" $it ") }

        // Сортируем согласно условию:
        println("\nПреобразованный массив:")
        for (i in array.indices)
            if (array[i] % 3 == 0 && array[i] % 5 == 0) print("$i ")
    }
}

class LabThirdNumber_7 {
    //Базовый класс – летательный аппарат. Производные – самолет и вертолет. Создать класс Авиакомпания, который
    //может содержать оба вида объектов. Предусмотреть метод подсчета отдельно самолетов и вертолетов
    //(использовать оператор is).

    open class FlyingApparatus( // Суперкласс - летательный аппарат
        var name_model: String = "Неизвестно",
        var maxSpeed: Int = 0,
        var maxLevelFlying: Int = 0
    )

    // Производный класс – самолет.
    class Airplane(
        //Field's superclass:
        name_model: String = "Неизвестно",
        maxSpeed: Int = 0,
        maxLevelFlying: Int = 0,

        // Field's base class:
        var numPassengers: Int = 300,
        var autopilot: Boolean = false
    ) : FlyingApparatus(name_model, maxSpeed, maxLevelFlying) {

        fun setAirplane() {
            print("Введите название модели самолета: ")
            name_model = readLine()!!
            print("Введите максимальную скорость самолета: ")
            maxSpeed = readLine()!!.toInt();
            print("Введите максимальный уровень высоты для полета: ")
            maxLevelFlying = readLine()!!.toInt()
            print("кол-во пассажиров самолета: ");
            numPassengers = readLine()!!.toInt()
            print("Есть ли функция автопилота ");
            autopilot = readLine()!!.toBoolean()
            println()
        }

        override fun toString() = "Самолет (модель=$name_model, максСкорость=$maxSpeed " +
                "кол-во пассажиров=$numPassengers, есть автопилот? =${if (autopilot) "да" else "нет"} )"
    }


    class Helicopter(
        //Field's superclass:
        name_model: String = "Неизвестно",
        maxSpeed: Int = 0,
        maxLevelFlying: Int = 0,

        // Field's base class:
        var is_licencia: String = "АФП00000",
        var propeller_revolutions: Int = 0,

        ) : FlyingApparatus(name_model, maxSpeed, maxLevelFlying) {

        fun setHelicopter() {
            print("Введите название модели вертолета: ")
            name_model = readLine()!!
            print("Введите максимальную скорость вертолета: ")
            maxSpeed = readLine()!!.toInt();
            print("Введите максимальный уровень высоты для полета: ")
            maxLevelFlying = readLine()!!.toInt()
            print("номер ли лицензия у пилота: ");
            is_licencia = readLine()!!
            print("Количество оборотов несущего винта в минуту ");
            propeller_revolutions = readLine()!!.toInt()
            println()
        }

        override fun toString() = "Вертолет (модель=$name_model, максСкорость=$maxSpeed " +
                "Максимальный уровень высоты= $maxLevelFlying, номер лицензии? =$is_licencia, количество оборотов несущего винта =$propeller_revolutions )"
    }

    class Airline() { // Класс агрегатор
        private var masFlyingApparatus = ArrayList<FlyingApparatus>();
        private var countAirplane = 0;
        private var countHelicopter = 0;
        fun addFlyApp(flyApp: FlyingApparatus) { //для добавления объектов в массив
            masFlyingApparatus.add(flyApp)
        }

        //метод для поиска самолетов в ангаре:
        fun findAirplane(): Int {
            for (a in masFlyingApparatus) {
                if (a is Airplane) ++countAirplane;
            }
            return countAirplane;
        }

        //метод для поиска вертолетов в ангаре:
        fun findHelicopter(): Int {
            for (a in masFlyingApparatus) {
                if (a is Helicopter) ++countHelicopter;
            }
            return countHelicopter;
        }

        override fun toString(): String { //для вывода в консоль
            var str = "В ангаре:\n "
            for (a in masFlyingApparatus) {
                str = str + ("\t" + a + "\n")
            }
            return str
        }
    }

}


fun main() {
    // First by lab's:
    //val Lab1_number_19: LabFirstNumber_19 = LabFirstNumber_19()
    //val Lab1_number_9: LabFirstNumber_9 = LabFirstNumber_9()

    // Second by lab's:
    //val Lab2_number_19: LabSecondNumber_19 = LabSecondNumber_19()
    //val Lab2_number_7: LabSecondNumber_7 = LabSecondNumber_7()

    // Third by lab's:

    // Создаем объект класса агрегатора:
    val airline: LabThirdNumber_7.Airline = LabThirdNumber_7.Airline()
    // Создаем одно НЛО:
    airline.addFlyApp(LabThirdNumber_7.FlyingApparatus("Ford", 400))
    //Создание двух вертолётов:
    airline.addFlyApp(LabThirdNumber_7.Helicopter("MK-12", 200, 1000, "HKU50001", 1200))
    airline.addFlyApp(LabThirdNumber_7.Helicopter("YVS-90", 300, 1200, "IO1231", 300))
    //Создание трех самолетов:
    airline.addFlyApp(LabThirdNumber_7.Airplane("Tukov-89", 45, 1200, 300, true))
    airline.addFlyApp(LabThirdNumber_7.Airplane("Hi-0", 120, 500, 1290, true))
    airline.addFlyApp(LabThirdNumber_7.Airplane("AR-74", 345, 560, 20, false))
    // Вывод содержания ангара:
    println(airline)
    // Подсчет вертолетов:
    println("Кол-во вертолетов = " + airline.findHelicopter())
    // Подсчет самолетов:
    println("Кол-во самолетов = " + airline.findAirplane())
}
