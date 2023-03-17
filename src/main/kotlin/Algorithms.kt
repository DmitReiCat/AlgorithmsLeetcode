/**
 * Дано целое число n.
 * Требуется вывести все правильные скобочные последовательности длины 2 * n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 * В задаче используются только круглые скобки.
 */
fun rightBracketSequenceIterative(m: Int) {
    val n = m * 2
    val arr = Array(n) { ' ' }
    arr.fill('(', 0, m)
    arr.fill(')', m, n)

    println(arr.toList().joinToString(""))
    while (true) {
        var ind = n - 1
        var cnt = 0
        // находим откр. скобку, которую можно заменить
        while (ind >= 0) {
            if (arr[ind] == ')') cnt -= 1
            if (arr[ind] == '(') cnt += 1
            if (cnt < 0 && arr[ind] =='(') break
            ind -= 1
        }
        // если не нашли, то алгоритм заканчивает работу
        if (ind < 0) break
        // заменяем на закр. скобку
        arr[ind] = ')'
        // заменяем на самую лексикографическую минимальную
        for (i in ind+1 until n) {
            if (i <= (n - ind + cnt) / 2 + ind) arr[i] = '('
            else arr[i] = ')'
        }
        println(arr.toList().joinToString(""))
    }
}


fun main() {
    rightBracketSequenceIterative(3)
}