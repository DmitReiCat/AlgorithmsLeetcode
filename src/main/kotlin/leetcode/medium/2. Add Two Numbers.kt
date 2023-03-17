package leetcode.medium

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
    val headListNode = ListNode(0)
    var lastListNode: ListNode? = null
    var currentListNode = headListNode

    var savedSum = 0
    var _l1: ListNode? = l1
    var _l2: ListNode? = l2
    while (_l1 != null || _l2 != null) {
        val currentSum = (_l1?.`val` ?: 0 ) + (_l2?.`val` ?: 0) + currentListNode.`val`
        currentListNode.`val` = currentSum % 10
        currentListNode.next = ListNode(currentSum / 10)

        lastListNode = currentListNode
        currentListNode = currentListNode.next!!
        _l1 = _l1?.next
        _l2 = _l2?.next
    }
    if (currentListNode.`val` == 0) lastListNode?.next = null
    return headListNode
}

fun main() {
}