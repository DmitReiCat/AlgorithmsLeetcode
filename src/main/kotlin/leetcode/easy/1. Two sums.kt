package leetcode.easy


private fun twoSum(nums: IntArray, target: Int): IntArray {
    val mapNums = mutableMapOf<Int, Array<Int?>>()
    nums.forEachIndexed { index, item ->
        mapNums[item]?.apply {
            this[1] = index
        } ?: run { mapNums[item] = Array<Int?>(2) { null }.apply { this[0] = index } }
    }

    nums.forEach { item ->
        if (mapNums[target - item] != null) {
            if (mapNums[target - item] != mapNums[item]) {
                return intArrayOf(mapNums[target - item]!![0]!!, mapNums[item]!![0]!!)
            } else if (mapNums[target - item]!!.count { it != null } == 2) {
                return intArrayOf(mapNums[item]!![0]!!, mapNums[item]!![1]!!)
            }
        }
    }
    return intArrayOf() // never used
}