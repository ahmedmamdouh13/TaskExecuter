package com.luftborn.taskexecuterapp.util

import java.util.*

typealias DisplayableDate = String

object DateUtil {

    fun getDisplayableDate(): String {
        val calendar = GregorianCalendar.getInstance()

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH) + 1
        val year = calendar.get(Calendar.YEAR)

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return "${getDigital(day)}-${getDigital(month)}-$year ${getDigital(hour)}:${getDigital(minute)}"
    }

    private fun getDigital(digit: Int): String {
        return if (digit < 10) "0$digit" else digit.toString()
    }

}
