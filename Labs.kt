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
        var array = IntArray(n, { Random.nextInt(10) })
        println("массив:")
        array.forEach { print(" $it ") }

        // Сортируем согласно условию:
        println("\nПреобразованный массив:")
        var i = 0;
        var test: IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        test.forEach { print("${if ((i++ != 0) && (((i++) % 5 == 0) || ((i++) % 3 == 0))) "$it " else ""}") }
    }
}


fun main() {
    // First by lab's:
    //val Lab1_number_19: LabFirstNumber_19 = LabFirstNumber_19()
    //val Lab1_number_9: LabFirstNumber_9 = LabFirstNumber_9()

    // Second by lab's:
    //val Lab2_number_19: LabSecondNumber_19 = LabSecondNumber_19()
    val Lab2_number_7: LabSecondNumber_7 = LabSecondNumber_7()

    // Third by lab's:

}
