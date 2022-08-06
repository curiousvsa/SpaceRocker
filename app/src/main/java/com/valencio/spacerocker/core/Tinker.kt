package com.valencio.spacerocker.core

import com.valencio.spacerocker.game.common.Millis
import com.valencio.spacerocker.game.common.Never
import com.valencio.spacerocker.game.common.Once
import com.valencio.spacerocker.game.common.RepeatTime


private val tinkerMap = mutableMapOf<String, Long>()

fun tinker(id: String, repeatTime: RepeatTime, doWork: () -> Unit) {
    if (repeatTime is Never) return
    if (repeatTime is Once && tinkerMap.containsKey(id)) return
    if (!tinkerMap.containsKey(id)) {
        tinkerMap[id] = System.currentTimeMillis()
        doWork()
    }
    val value: Long? = tinkerMap[id]
    val elapseTimeMillis = value?.let { System.currentTimeMillis() - it } ?: -1
    if (repeatTime is Millis && elapseTimeMillis > repeatTime.timeMillis) {
        tinkerMap[id] = System.currentTimeMillis()
        doWork()
    }
}